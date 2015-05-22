/**
 * 
 */
function closeDialogIfSucess(xhr, status, args, dialogWidget, dialogId) {
    if (args.validationFailed || args.KEEP_DIALOG_OPENED) {
        jQuery('#'+dialogId).effect("bounce", {times : 4, distance : 20}, 100);
    } else {
    	PF(dialogWidget).hide();
    }
}

function handleDrop(event, ui) {
    var droppedCar = ui.draggable;

    droppedCar.fadeOut('fast');
}

function start() {
    PF('statusDialog').show();
}
 
function stop() {
    PF('statusDialog').hide();
}
