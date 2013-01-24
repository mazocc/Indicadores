function adicionaListeners(route, formSelector) {
    $(formSelector).focusout(function () {
        $.ajax({
            url: route.url(),
            method: route.method,
            data: $(this).serialize()
        });
    });
}
