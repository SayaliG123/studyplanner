let tasks = [];

function addTask() {

    let subject = document.getElementById("subject").value;
    let difficulty = parseInt(document.getElementById("difficulty").value);
    let days = parseInt(document.getElementById("days").value);

    let task = {
        subject: subject,
        difficulty: difficulty,
        daysLeft: days
    };

    tasks.push(task);

    sortTasks();
    generatePlan();
}

function sortTasks() {
    tasks.sort((a, b) => {
        let p1 = a.difficulty * 2 + (10 - a.daysLeft);
        let p2 = b.difficulty * 2 + (10 - b.daysLeft);
        return p2 - p1;
    });
}

function generatePlan() {

    let list = document.getElementById("taskList");
    list.innerHTML = "";

    tasks.forEach(t => {

        let hours = t.difficulty * 2;

        if (t.daysLeft < 3) {
            hours += 2;
        }

        let li = document.createElement("li");
        li.textContent = t.subject + " → " + hours + " hours";

        list.appendChild(li);
    });
}