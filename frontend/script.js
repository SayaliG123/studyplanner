let tasks = [];

function addTask() {

    let subject = document.getElementById("subject").value.trim();
    let difficulty = parseInt(document.getElementById("difficulty").value);
    let days = parseInt(document.getElementById("days").value);

    // validation
    if (!subject || isNaN(difficulty) || isNaN(days)) {
        alert("Please enter valid input!");
        return;
    }

    let task = {
        subject: subject,
        difficulty: difficulty,
        daysLeft: days
    };

    tasks.push(task);

    sortTasks();
    generatePlan();

    // clear inputs
    document.getElementById("subject").value = "";
    document.getElementById("difficulty").value = "";
    document.getElementById("days").value = "";
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

        let days = t.daysLeft === 0 ? 1 : t.daysLeft;

        let baseHours = t.difficulty * 1.5;
        let urgency = 5 / days;

        let hours = baseHours + urgency;

        if (hours < 1.5) hours = 1.5;
        if (hours > 7) hours = 7;

        let li = document.createElement("li");
        li.textContent = t.subject + " → " + hours.toFixed(1) + " hours";

        list.appendChild(li);
    });
}