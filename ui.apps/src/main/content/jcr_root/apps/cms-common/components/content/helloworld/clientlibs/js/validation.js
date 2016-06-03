'use strict';

(function ($, Granite) {

    $.validator.register({
        selector: "[data-validation~='aem.field.email']",
        validate: function (e) {
            var value = e.val();
            var reg = new RegExp('.*[@]+.*');
            if (!reg.test(value)) {
                return Granite.I18n.get("Email format is invalid. This is validator from RDS");
            }
        }
    });
})(Granite.$, Granite)