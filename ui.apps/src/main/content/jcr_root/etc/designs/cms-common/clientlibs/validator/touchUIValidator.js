/**
 * Created on 8/16/16.
 */
var touchValidator = (function ($, G) {
    'use strict';

    $.validator.register({
        selector: "[data-validation~='aem.field.email']",
        validate: function () {

        }
    });

    return {};
})(Granite.$, Granite);