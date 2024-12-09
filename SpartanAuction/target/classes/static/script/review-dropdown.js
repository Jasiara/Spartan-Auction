console.log("Here");

let idsArray = document.querySelectorAll('*[id]');

let repliesArray = [];
for (let index = 0; index < idsArray.length; index++) {
    if (idsArray[index].id.startsWith("review-button")) {
        repliesArray.append(idsArray[index]);
    }
}


console.log("Here Now 1");
console.log(repliesArray);
for (let index = 0; index < repliesArray.length; index++) {
    repliesArray[index].addEventListener('click', () => {
        let replyForm = document.getElementById("reply-form-" + { index });
        replyForm.classList.add("show");
    });
}

console.log("Here Now 2");