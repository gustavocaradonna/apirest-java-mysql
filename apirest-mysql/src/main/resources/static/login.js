// Espera a que el documento esté completamente cargado antes de ejecutar el código JavaScript
$(document).ready(function () {
    // Seleccionar el formulario
    const form = $('#loginForm');

    // Agregar evento de submit al formulario
    form.submit(function (event) {
        event.preventDefault(); // Evitar el envío del formulario por defecto

        // Log para verificar que el evento de envío del formulario se captura correctamente
        console.log('Form submit event captured');

        // Obtener los valores de usuario y contraseña del formulario
        const username = $('#username').val();
        const password = $('#password').val();
        // Realizar la solicitud POST al servidor con los parámetros de usuario y contraseña
        $.ajax({
            url: '/apirest/login/test',
            method: 'POST',
            contentType: 'application/json',
            data: JSON.stringify({username: username, password: password}),
            success: function (response) {
                // Manejar la respuesta del servidor
                if (response === 'success') {
                    console.log('Login successful!');
                    window.location.href = '/loggedin.html';
                } else {
                    console.error('Authentication failed!');
                    alert("Ingreso incorrecto, vuelva a intentar");
                    // Aquí podrías mostrar un mensaje de error al usuario
                }
            },
            error: function (xhr, status, error) {
                // Manejar errores de la solicitud
                console.error('Error en la solicitud:', error);
            }
        });
    });
});
