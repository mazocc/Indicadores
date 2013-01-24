function adicionaListeners(route, formSelector) {
    $(formSelector).focusout(function () {
        console.log($(this).serialize());
        $.ajax({
            url: route.url(),
            method: route.method,
            data: $(this).serialize()
        });
    });
}
