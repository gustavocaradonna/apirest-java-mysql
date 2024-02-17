$(document).ready(function () {
    // Seleccionar el formulario
    const form = $('#loginForm');

    // Agregar evento de submit al formulario
    form.submit(function (event) {
        event.preventDefault(); // Evitar el envío del formulario por defecto

        // Obtener los valores de usuario y contraseña del formulario
        const username = $('#username').val();
        const password = $('#password').val();

        // Realizar la solicitud POST al servidor
        $.ajax({
            url: '/login',
            method: 'POST',
            contentType: 'application/json',
            data: JSON.stringify({
                username: username,
                password: password
            }),
            success: function () {
                // Redireccionar o realizar alguna acción en caso de éxito
                console.log('Login successful!');
            },
            error: function () {
                // Manejar el caso de error de autenticación
                console.error('Authentication failed!');
            }
        });
    });
});
