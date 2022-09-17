//targetId ahova az eredményt akarom kiírni, messageId ahova a detailst akarom kiírni
function getRoll(rollDefinition){
    getServerData("http://localhost:8080/api/roll/" + rollDefinition).then(
        roll => alert(roll)
    );
}

const messagePlaceHolder = document.getElementById("messagePlaceHolder");

const alert = (message) => {
    const wrapper = document.createElement('div')
    wrapper.innerHTML = [
        `<div class="alert alert-success alert-dismissible fade show" role="alert">`,
        `   <div>${message.details}</div>`,
        '   <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>',
        '</div>'
    ].join('')

    messagePlaceHolder.append(wrapper)
}

function getServerData(url) {
    let fetchOptions = {
        method: "GET",
        mode: "cors",
        cache: "no-cache"
    };

    return fetch(url, fetchOptions).then(
        response => response.json(),
        err => console.error(err)
    )
}




