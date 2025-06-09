document.getElementById('feedbackForm').addEventListener('submit', function (e) {
    e.preventDefault();

    let form = e.target;
    let data = {
        name: form.name.value,
        email: form.email.value,
        rating: form.rating.value,
        message: form.message.value
    };

    fetch('http://localhost:8080/api/submit', {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify(data),
        mode: 'cors'
    })
    .then(response => {
        if (response.ok) {
            return response.text();
        } else {
            throw new Error("Failed to submit feedback");
        }
    })
    .then(msg => {
        if (msg === "Saved") {
            window.location.href = "thankyou.html"; // redirect only if DB saved
        } else {
            alert("Something went wrong. Please try again.");
        }
    })
    .catch(err => {
        console.error(err);
        alert("Server error. Feedback not saved.");
    });
});
