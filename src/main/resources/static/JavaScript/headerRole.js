function handleRoleChange() {
    const role = document.getElementById('roleSelect').value;
    window.location.href = `/${role}`;
}