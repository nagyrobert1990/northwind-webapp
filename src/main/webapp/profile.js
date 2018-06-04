function onProfileLoad(customer) {
    clearMessages();
    showContents(['profile-content', 'logout-content']);

    const customerNameSpandEl = document.getElementById('company-name');

    customerNameSpandEl.textContent = customer.companyName;
}