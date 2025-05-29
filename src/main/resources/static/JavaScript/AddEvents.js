 document.addEventListener('DOMContentLoaded', function () {
    const form = document.getElementById('eventForm'); // Get the form element
    const title = document.getElementById('title');
    const date = document.getElementById('date');
    const location = document.getElementById('location');
    const category = document.getElementById('category');
    const description = document.getElementById('description');

    form.addEventListener('submit', function (e) {
    let valid = true;
    // Clear previous error messages
    clearErrors();

    // Check if all required fields are filled
    if (!title.value.trim()) {
    showError(title, 'Title is required');
    valid = false;
}

    if (!date.value.trim()) {
    showError(date, 'Date is required');
    valid = false;
}

    if (!location.value.trim()) {
    showError(location, 'Location is required');
    valid = false;
}

    if (!category.value.trim()) {
    showError(category, 'Category is required');
    valid = false;
}

    if (!description.value.trim()) {
    showError(description, 'Description is required');
    valid = false;
}

    // If not valid, prevent form submission
    if (!valid) {
    e.preventDefault();
}
});

    // Function to show error message next to the input field
    function showError(input, message) {
    const errorElement = document.createElement('span');
    errorElement.style.color = 'red';
    errorElement.textContent = message;
    input.parentElement.appendChild(errorElement);
}

    // Function to clear previous error messages
    function clearErrors() {
    const errorMessages = document.querySelectorAll('span');
    errorMessages.forEach(error => error.remove());
}
});

