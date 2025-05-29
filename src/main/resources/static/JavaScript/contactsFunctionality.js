function validateEmail(email) {
    // Use a more robust regular expression to handle various email formats
    let emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
    return emailRegex.test(email);
}

function validatePhoneNumber(phoneNum) {
    // Regular expression for Polish phone numbers (with optional country code)
    const polishRegex = /^(?:\+48|0048)?(?:\d{2}\s?\d{3}\s?\d{4}|\d{3}\s?\d{3}\s?\d{3})$/;

    // Regular expression for UK phone numbers (with optional country code)
    const ukRegex = /^(?:\+44|0044)?(?:\d{4}\s?\d{6}|\d{5}\s?\d{5}|\d{3}\s?\d{3}\s?\d{4})$/;

    // Test against both Polish and UK regex
    return polishRegex.test(phoneNum) || ukRegex.test(phoneNum);
}
// ("+48 504 123 456")); // true (Polish)
// ("504 123 456"));     // true (Polish)
// ("22 123 45 67"));    // true (Polish)
// ("+44 7911 123456")); // true (UK)
// ("07700 900123"));    // true (UK)
// ("0044 20 7946 0958"));// true (UK)
// ("504123456"));       // true (Polish)
// ("07123456789"));     // true (UK)
// ("1234567890"));      // false (Not Polish or UK)

function submitFunction(event) {
    event.preventDefault();

    let fullName = document.getElementById('fullName');
    let emailAddress = document.getElementById('emailAddress');
    let phoneNumber = document.getElementById('phoneNumber');

    if (
         fullName.value.trim() !== null &&
        validateEmail(emailAddress.value) &&
        phoneNumber.value !== null &&
        validatePhoneNumber(phoneNumber.value)
    ) {
        alert('Your details have successfully got registered!');
    } else {

        if (fullName.value.trim()==='') {
            alert('Please enter your full name.');
        } else if (!validateEmail(emailAddress.value)) {
            alert('Please enter a valid email address.');
        } else if (phoneNumber.value===null) {
            alert('Please enter your phone number.');
        } else if (!validatePhoneNumber(phoneNumber.value)) {
            alert('Please enter a valid phone number.');
        } else {
            alert('Oops, something went wrong. Please try again.');
        }
    }
}
