//targetId ahova az eredményt akarom kiírni, messageId ahova a detailst akarom kiírni
function getCustomRoll(diceDefinition){
    const times = document.getElementById("times");
    if (times){
        getRoll(times.value + diceDefinition);
    }else{
        getRoll(diceDefinition);
    }
}

function getRoll(rollDefinition){
    getServerData("http://localhost:8080/api/roll/" + rollDefinition).then(
        roll => message(roll, rollDefinition)
    );
}

const message = (roll, rollDefinition) => {
    const wrapper = document.querySelector(".toast-container");
    const randomUUID = crypto.randomUUID();

    wrapper.innerHTML += [
        `<div id="${randomUUID}" class="toast show" role="alert" aria-live="assertive" aria-atomic="true" data-bs-autohide="false">`,
        `    <div class="toast-header">`,
        `        <strong class="me-auto">${rollDefinition}</strong>`,
        `        <button type="button" class="btn-close" onclick="removeElement('${randomUUID}')" aria-label="Close"></button>`,
        `    </div>`,
        `    <div class="toast-body">`,
        `       ${roll.details}`,
        `    </div>`,
        `</div>`
    ].join('')

    const toastList = document.querySelectorAll(".toast");

    if(toastList.length === 6){
        removeElement(toastList[0].id);
    }
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

function removeElement(id){
    const element = document.getElementById(id);
    element.remove();
}



