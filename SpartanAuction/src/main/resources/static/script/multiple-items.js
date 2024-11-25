let countdowns = [];

for (let i = 0; i < datesArr.length; i++) {
       countdowns.push(new Date(datesArr[i]).getTime());
}
console.log(countdowns);
                function updateCountdowns() {
                    let now = new Date();


                    for (let index = 0; index < countdowns.length; index++) {
                        let targetTime = countdowns[index];
                        let timeLeft = targetTime - now;

                        if (timeLeft < 0) {
                            console.log(`auction-end${index}`);
                            document.getElementById(`auction-end${index}`).innerHTML = "Auction Over!";
                        } else {

                            let days = Math.floor((timeLeft / (1000 * 60 * 60 * 24)));
                            let hours = Math.floor((timeLeft % (1000 * 60 * 60 * 24)) / (1000 * 60 * 60));
                            let minutes = Math.floor((timeLeft % (1000 * 60 * 60)) / (1000 * 60));
                            let seconds = Math.floor((timeLeft % (1000 * 60)) / 1000);

                            document.getElementById('auction-end' + index).innerHTML = "Time Left: " + days + ' D ' + hours + ' H '
                            + minutes + " M " + seconds +' S';
                        }
                    }

                }
                setInterval(updateCountdowns, 1000);
                updateCountdowns();