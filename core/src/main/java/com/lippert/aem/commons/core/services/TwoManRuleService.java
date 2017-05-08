package com.lippert.aem.commons.core.services;

import javax.jcr.RepositoryException;
import javax.jcr.Session;

/**
 * The service enables to use the two man rule in workflows (e.g. activation
 * or deactivation) workflows
 */

public interface TwoManRuleService {

    /**
     * @param jcrSession A jcr session
     * @param payload    The path to the payload
     * @param userId     The userId of the current User
     * @param initiator  The initiator of the workflow
     * @return Returns true if the current user is allowed to approve. Otherwise returns false.
     */

    Boolean isApprovalAllowed(Session jcrSession, String payload, String userId, String initiator) throws RepositoryException;

}
