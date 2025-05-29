document.getElementById("searchBtn").addEventListener("click", function () {
    // Get filter values
    var selectedLocation = document.getElementById("Location").value.trim();
    var selectedCategory = document.getElementById("Category").value.trim();
    var startDate = document.getElementById("start-date").value;
    var endDate = document.getElementById("end-date").value;

    // Convert start and end dates to Date objects
    var startDateObj = startDate ? new Date(startDate) : null;
    var endDateObj = endDate ? new Date(endDate) : null;

    // Select all event cards
    var eventCards = document.querySelectorAll(".event-card");

    // Loop through each event card
    eventCards.forEach(function (card) {
        // Extract event data
        var eventLocation = card.querySelector(".location").textContent.trim();
        var eventCategory = card.querySelector(".category").textContent.trim();
        var eventDate = new Date(card.querySelector(".date").textContent.trim());

        // Match filters
        var matchesLocation = !selectedLocation || eventLocation === selectedLocation;
        var matchesCategory = !selectedCategory || eventCategory === selectedCategory;
        var matchesDate =
            (!startDateObj || eventDate >= startDateObj) &&
            (!endDateObj || eventDate <= endDateObj);

        // Show or hide the card based on matches
        card.style.display = matchesLocation && matchesCategory && matchesDate ? "block" : "none";
    });
});