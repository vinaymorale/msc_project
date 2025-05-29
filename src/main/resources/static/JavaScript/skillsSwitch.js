document.addEventListener("DOMContentLoaded", function () {
    const toggleButton = document.getElementById("toggleButton");
    const skillsSection = document.querySelector(".skills-grid:nth-of-type(1)");
    const resourcesSection = document.querySelector(".skills-grid:nth-of-type(2)");
    const currentSectionHeading = document.getElementById("currentSection");

    resourcesSection.style.display = "none";
    currentSectionHeading.textContent = "Skills and Qualifications";

    toggleButton.addEventListener("click", function () {
        if (skillsSection.style.display === "none") {
            skillsSection.style.display = "grid";
            resourcesSection.style.display = "none";
            currentSectionHeading.textContent = "Skills and Qualifications";
            toggleButton.textContent = "View Learning Resources";
        } else {
            skillsSection.style.display = "none";
            resourcesSection.style.display = "grid";
            currentSectionHeading.textContent = "Language Resources";
            toggleButton.textContent = "Learn Skills and Earn Qualifications";
        }
    });
});
