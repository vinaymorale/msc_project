// Add Ionicons scripts dynamically if needed
(function() {
    var ionIconsModule = document.createElement('script');
    ionIconsModule.type = 'module';
    ionIconsModule.src = 'https://unpkg.com/ionicons@7.1.0/dist/ionicons/ionicons.esm.js';
    document.head.appendChild(ionIconsModule);

    var ionIconsNoModule = document.createElement('script');
    ionIconsNoModule.nomodule = true;
    ionIconsNoModule.src = 'https://unpkg.com/ionicons@7.1.0/dist/ionicons/ionicons.js';
    document.head.appendChild(ionIconsNoModule);
})();

// Handle the 'click' event for each question
document.addEventListener('DOMContentLoaded', function() {
    const questions = document.querySelectorAll('.question');

    questions.forEach(function(question) {
        question.addEventListener('click', function() {
            question.classList.toggle('open'); // Toggle 'open' class on click
        });
    });

    // Handle 'change' event for the filter_topic select element
    const filterTopic = document.getElementById('filter_topic');
    if (filterTopic) {
        filterTopic.addEventListener('change', function() {
            var selectedFilter = this.value;
            var questions = document.querySelectorAll('.question');

            questions.forEach(function(question) {
                if (selectedFilter === 'all' || question.getAttribute('data-topic') === selectedFilter) {
                    question.style.display = 'flex'; // Show the question
                } else {
                    question.style.display = 'none'; // Hide the question
                }
            });
        });
    }
});
