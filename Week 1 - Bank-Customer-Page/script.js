let balance = 10000;

let totalTransactions = 0;

function updateBalance(){

    document.getElementById("balance").innerHTML = balance;

    document.getElementById("count").innerHTML = totalTransactions;

}

function depositMoney(){

    let amount = Number(document.getElementById("amount").value);

    if(amount == ""){

        alert("Please enter amount.");

        return;

    }

    if(amount <= 0){

        alert("Enter valid amount.");

        return;

    }

    balance = balance + amount;

    totalTransactions = totalTransactions + 1;

    updateBalance();

    let today = new Date();

    let item = document.createElement("li");

    item.innerHTML =
    "Deposited ₹" + amount +
    " on " +
    today.toLocaleString();

    document.getElementById("history").appendChild(item);

    document.getElementById("lastTransaction").innerHTML =
    "Deposited ₹" + amount;

    document.getElementById("amount").value = "";

    alert("Money Deposited Successfully");

}

function withdrawMoney(){

    let amount = Number(document.getElementById("amount").value);

    if(amount == ""){

        alert("Please enter amount.");

        return;

    }

    if(amount <= 0){

        alert("Enter valid amount.");

        return;

    }

    if(amount > balance){

        alert("Insufficient Balance");

        return;

    }

    balance = balance - amount;

    totalTransactions = totalTransactions + 1;

    updateBalance();

    let today = new Date();

    let item = document.createElement("li");

    item.innerHTML =
    "Withdrawn ₹" + amount +
    " on " +
    today.toLocaleString();

    document.getElementById("history").appendChild(item);

    document.getElementById("lastTransaction").innerHTML =
    "Withdrawn ₹" + amount;

    document.getElementById("amount").value = "";

    alert("Money Withdrawn Successfully");

}

function clearInput(){

    document.getElementById("amount").value = "";

}