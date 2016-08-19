(function (Granite, $) {    
    'use strict';
    $.validator.register({
        selector: "[data-validation~='aem.field.email']",
        validate: function (e) {
            var value = e.val(), reg = new RegExp('.*[@]+.*');
            if (!reg.test(value)) {
                return Granite.I18n.get("Email format is invalid. This is validator from RDS");
            }
        },
        show: function (el, message) {
            var fieldErrorEl,field,error,arrow;
            fieldErrorEl = $("<div class='coral-Alert coral-Alert--error'><button type='button' class='coral-MinimalButton coral-Alert-closeButton' title='Close' data-dismiss='alert'><i class='coral-Icon coral-Icon--sizeXS coral-Icon--close coral-MinimalButton-icon'></i></button><i class='coral-Alert-typeIcon coral-Icon coral-Icon--sizeS coral-Icon--alert'></i><strong class='coral-Alert-title'>Error</strong><div class='coral-Alert-message'>"+message+"</div></div>");
            field = el.closest(".coral-Form");
            fieldErrorEl.insertBefore(field);
        }
    });
}(Granite, Granite.$));