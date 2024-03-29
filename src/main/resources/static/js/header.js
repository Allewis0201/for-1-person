function includeHeader() {
    var xhr = new XMLHttpRequest();
    xhr.open('GET', 'header.html', true);
    xhr.onreadystatechange = function() {
        if (xhr.readyState === XMLHttpRequest.DONE && xhr.status === 200) {
            document.getElementById('header').innerHTML = xhr.responseText;

            activateModal();

        }
    };
    xhr.send();
}


window.onload = includeHeader;