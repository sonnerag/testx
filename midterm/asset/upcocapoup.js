// Calendar Popup functionality
const calendarTrigger = document.getElementById("calendar-trigger");
const calendarContainer = document.getElementById("calendar-container");
let currentDate = new Date(2024, 9); // October 2024

// Toggle calendar visibility when the trigger is clicked
calendarTrigger.addEventListener("click", (e) => {
    e.stopPropagation(); // Prevent this click from closing the calendar
    calendarContainer.classList.toggle("hidden");
    renderCalendar();
});

// Close the calendar when clicking outside of it
document.addEventListener("click", (e) => {
    if (!calendarContainer.contains(e.target) && !calendarTrigger.contains(e.target)) {
        calendarContainer.classList.add("hidden");
    }
});

// Navigate to the previous month
document.getElementById("prev-month").addEventListener("click", () => {
    currentDate.setMonth(currentDate.getMonth() - 1);
    renderCalendar();
});

// Navigate to the next month
document.getElementById("next-month").addEventListener("click", () => {
    currentDate.setMonth(currentDate.getMonth() + 1);
    renderCalendar();
});

// Function to render the calendar for the current month
function renderCalendar() {
    const month = currentDate.getMonth();
    const year = currentDate.getFullYear();

    document.getElementById("current-month").textContent = `${currentDate.toLocaleDateString("en", { month: "long" })} ${year}`;
    
    const firstDayOfMonth = new Date(year, month, 1).getDay();
    const daysInMonth = new Date(year, month + 1, 0).getDate();
    const calendarBody = document.getElementById("calendar-body");

    calendarBody.innerHTML = ""; // Clear previous calendar data

    let row = document.createElement("tr");

    // Fill the first row with empty cells if the month doesn't start on Sunday
    for (let i = 0; i < firstDayOfMonth; i++) {
        const emptyCell = document.createElement("td");
        row.appendChild(emptyCell);
    }

    // Populate the calendar with days
    for (let day = 1; day <= daysInMonth; day++) {
        const cell = document.createElement("td");
        cell.textContent = day;
        cell.addEventListener("click", () => {
            alert(`Selected date: ${day} ${currentDate.toLocaleDateString("en", { month: "long", year: "numeric" })}`);
        });

        row.appendChild(cell);

        // Start a new row if the week is complete or if it's the last day of the month
        if ((day + firstDayOfMonth) % 7 === 0 || day === daysInMonth) {
            calendarBody.appendChild(row);
            row = document.createElement("tr");
        }
    }
}

// Initial rendering of the calendar when the page loads
renderCalendar();
