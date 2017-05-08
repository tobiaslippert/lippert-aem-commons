package com.lippert.aem.commons.core.services.impl;

import javax.jcr.Node;
import javax.jcr.RepositoryException;
import javax.jcr.Session;

import org.apache.commons.lang3.StringUtils;
import org.osgi.service.component.annotations.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.day.cq.commons.jcr.JcrConstants;
import com.day.cq.wcm.api.NameConstants;

import com.lippert.aem.commons.core.services.TwoManRuleService;

@Component(service=TwoManRuleService.class, immediate=true)
public class TwoManRuleServiceImpl implements TwoManRuleService {

    private final static String JCR_PATH_CQ_LAST_MODIFIED_BY = "./" + JcrConstants.JCR_CONTENT + "/"
            + NameConstants.PN_PAGE_LAST_MOD_BY;
    private final static String JCR_PATH_CREATED_BY = "./" + JcrConstants.JCR_CONTENT + "/" + JcrConstants.JCR_CREATED_BY;
    private final static String JCR_PATH_JCR_LAST_MODIFIED_BY = "./" + JcrConstants.JCR_CONTENT + "/"
            + JcrConstants.JCR_LAST_MODIFIED_BY;

    private final static Logger LOG = LoggerFactory.getLogger(TwoManRuleService.class);

    @Override
    public Boolean isApprovalAllowed(Session jcrSession, String path, String userId, String initiator)
            throws RepositoryException {

        if (StringUtils.isBlank(userId)) {
            return false;
        }

        String lastModifier = "";

        //Initiators are not allowed to approve their own workflows
        if (StringUtils.equals(initiator, userId)) {
            return false;
        }


        try {
            Node node = jcrSession.getNode(path);

            if (node.hasProperty(JCR_PATH_CQ_LAST_MODIFIED_BY)) {
                lastModifier = node.getProperty(JCR_PATH_CQ_LAST_MODIFIED_BY).getString();
            } else if (node.hasProperty(JCR_PATH_JCR_LAST_MODIFIED_BY)) {
                lastModifier = node.getProperty(JCR_PATH_JCR_LAST_MODIFIED_BY).getString();
            } else {
                lastModifier = node.getProperty(JCR_PATH_CREATED_BY).getString();
            }

            if (StringUtils.equals(userId, lastModifier)) {
                return false;
            }

        } catch (RepositoryException e) {
            LOG.error("The access to the repository failed. The service step 'UserIsLastModifier' did not finished.");
            throw e;
        }

        return true;
    }
}