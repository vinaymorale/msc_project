// Password Visibility Toggle
function togglePasswordVisibility(id, iconId) {
    const passwordField = document.getElementById(id);
    const icon = document.getElementById(iconId);
    if (passwordField.type === 'password') {
        passwordField.type = 'text';
        icon.classList.remove('bi-eye');
        icon.classList.add('bi-eye-slash');
    } else {
        passwordField.type = 'password';
        icon.classList.remove('bi-eye-slash');
        icon.classList.add('bi-eye');
    }
}

// Validate form and password match
function validateForm(event) {
    const passwordField = document.getElementById('password');
    const confirmPasswordField = document.getElementById('confirmPassword');
    const password = passwordField.value;
    const confirmPassword = confirmPasswordField.value;

    // Clear any previous validation messages
    passwordField.setCustomValidity('');
    confirmPasswordField.setCustomValidity('');

    // Check if passwords match
    if (password !== confirmPassword) {
        // Custom message for password mismatch
        alert('The passwords do not match. Please ensure both passwords are the same.');
        window.location.reload(); // Reload the page to reset the form
        event.preventDefault(); // Prevent form submission
        return;
    }


}