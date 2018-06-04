function onLoginResponse() {
    if (this.status === OK) {
        const customer = JSON.parse(this.responseText);
        setAuthorization(customer);
        onProfileLoad(customer);
    } else {
        onOtherResponse(loginContentDivEl, this);
    }
}

function onLoginButtonClicked() {
    const loginFormEl = document.forms['login-form'];

    const customerIdInputEl = document.getElementById('customerId');;

    const customerId = customerIdInputEl.value;

    const params = new URLSearchParams();
    params.append('customerId', customerId);

    const xhr = new XMLHttpRequest();
    xhr.addEventListener('load', onLoginResponse);
    xhr.addEventListener('error', onNetworkError);
    xhr.open('POST', '/login');
    xhr.send(params);
}
