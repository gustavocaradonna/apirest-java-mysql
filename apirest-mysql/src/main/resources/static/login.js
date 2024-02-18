$(document).ready(function () {
    // Seleccionar el formulario
    const form = $('#loginForm');

    // Agregar evento de submit al formulario
    form.submit(function (event) {
        event.preventDefault(); // Evitar el envío del formulario por defecto

        // Obtener los valores de usuario y contraseña del formulario
        const username = $('#username').val();
        const password = $('#password').val();

        // Realizar la solicitud POST al servidor con los parámetros de usuario y contraseña
        $.ajax({
            url: '/login',
            method: 'POST',
            contentType: 'application/json',
            data: {
                username: username,
                password: password
            },
            success: function () {
                // Redireccionar al usuario a la página loggedin.html después del inicio de sesión exitoso
                console.log('Login successful!');
                window.location.href = '/loggedin';
            },
            error: function () {
                // Manejar el caso de error de autenticación
                console.error('Authentication failed!');
            }
        });
    });
});
