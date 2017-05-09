/*
 * Source: http://scrupulo.com/
 */

(function ($, document) {
    "use strict";
    $(document).on("foundation-contentloaded.disable-image-upload", function(e) {
    	$(".reenable-droptarget.cq-FileUpload.is-disabled")
    		.removeClass("is-disabled")
    		.find(".cq-FileUpload-label")
    			.html("Drop an asset here.");
    });

})(jQuery, document);