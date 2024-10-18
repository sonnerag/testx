// Retrieve the toggle button element
const toggleButton = document.getElementById("toggle-btn");

// Retrieve the sidebar element
const sidebar = document.getElementById("sidebar");

// Function to toggle the sidebar
function toggleSidebar() {
  // Toggle the "close" class on the sidebar element
  sidebar.classList.toggle("close");

  // Toggle the "rotate" class on the toggle button element
  toggleButton.classList.toggle("rotate");

  // Close all submenus when the sidebar is toggled
  closeAllSubMenus();

  const userSubmenu = document.getElementById("user__submenu");
  if (sidebar.classList.contains("close")) {
    userSubmenu.classList.remove("open-menu");
  }
}

// Function to toggle a submenu
function toggleSubMenu(button) {
  // Check if the submenu is not already open
  if (!button.nextElementSibling.classList.contains("show")) {
    // Close all submenus before opening a new one
    closeAllSubMenus();
  }

  // Toggle the "show" class on the submenu element
  button.nextElementSibling.classList.toggle("show");

  // Toggle the "rotate" class on the button element
  button.classList.toggle("rotate");

  // If the sidebar is currently closed, open it when a submenu is opened
  if (sidebar.classList.contains("close")) {
    sidebar.classList.toggle("close");
    toggleButton.classList.toggle("rotate");
  }
}

// Function to close all submenus
function closeAllSubMenus() {
  // Get all submenu elements with the "show" class
  Array.from(sidebar.getElementsByClassName("show")).forEach((ul) => {
    // Remove the "show" class from each submenu element
    ul.classList.remove("show");

    // Remove the "rotate" class from the previous sibling element (the button)
    ul.previousElementSibling.classList.remove("rotate");
  });
}

/*=============== user menu ===============*/
function toggleMenu() {
  const submenu = document.getElementById("user__submenu");
  submenu.classList.toggle("open-menu");
}

/*=============== SEARCH ===============*/
const search = document.getElementById("search"),
  searchBtn = document.getElementById("search-btn"),
  searchClose = document.getElementById("search-close");

/* Search show */
searchBtn.addEventListener("click", () => {
  search.classList.add("show-search");
});

/* Search hidden */
searchClose.addEventListener("click", () => {
  search.classList.remove("show-search");
});

// =============== to do list ===============
document.addEventListener("DOMContentLoaded", () => {
  const addTaskButtons = document.querySelectorAll(".add-task-btn");
  const submitTaskButtons = document.querySelectorAll(".submit-task-btn");
  const cancelTaskButtons = document.querySelectorAll(".cancel-task-btn");
  let activeTaskInputBox = null;

  // Show the input box and hide the Add Task button when clicked
  addTaskButtons.forEach((button) => {
    button.addEventListener("click", () => {
      const taskInputBox = button.nextElementSibling; // The task input box is the next sibling of the button
      if (activeTaskInputBox && activeTaskInputBox !== taskInputBox) {
        activeTaskInputBox.style.display = "none"; // Hide the previous box
        activeTaskInputBox.previousElementSibling.style.display = "block"; // Show the Add Task button
      }
      taskInputBox.style.display = "block";
      button.style.display = "none"; // Hide the Add Task button
      activeTaskInputBox = taskInputBox; // Update active box
    });
  });

  // Add task when the submit button is clicked
  submitTaskButtons.forEach((button) => {
    button.addEventListener("click", () => {
      const taskInputBox = button.parentElement;
      const taskName = taskInputBox.querySelector(".task-name").value;
      const taskDesc = taskInputBox.querySelector(".task-desc").value;

      if (taskName) {
        // Find the <ul> element inside the .date container and append the task to it
        const dateContainer = taskInputBox.closest(".date");
        const taskList = dateContainer.querySelector("ul");

        // Create a new <li> element for the task
        const newTask = document.createElement("li");
        newTask.setAttribute("draggable", "true"); // Make task draggable
        newTask.innerHTML = `<input type="checkbox"> <strong>${taskName}</strong><br><p>${taskDesc}</p><hr />`;
        taskList.appendChild(newTask);

        // Add event listeners for drag-and-drop to the new task
        addTaskEvents(newTask);

        // Reset input box and hide it
        taskInputBox.style.display = "none";
        taskInputBox.previousElementSibling.style.display = "block"; // Show Add Task button again
        taskInputBox.querySelector(".task-name").value = "";
        taskInputBox.querySelector(".task-desc").value = "";
      } else {
        alert("Please enter a task name.");
      }
    });
  });

  // Hide input box and show Add Task button when cancel is clicked
  cancelTaskButtons.forEach((button) => {
    button.addEventListener("click", () => {
      const taskInputBox = button.parentElement;
      taskInputBox.style.display = "none";
      taskInputBox.previousElementSibling.style.display = "block"; // Show Add Task button again
      taskInputBox.querySelector(".task-name").value = "";
      taskInputBox.querySelector(".task-desc").value = "";
    });
  });

  // Hide input box when clicking outside, and show the Add Task button
  document.addEventListener("click", (event) => {
    const target = event.target;
    if (
      !target.closest(".task-input-box") &&
      !target.classList.contains("add-task-btn")
    ) {
      if (activeTaskInputBox) {
        activeTaskInputBox.style.display = "none";
        activeTaskInputBox.previousElementSibling.style.display = "block"; // Show Add Task button again
        activeTaskInputBox = null;
      }
    }
  });

  // Add event listeners to existing tasks
  const tasks = document.querySelectorAll(".task-list li");
  tasks.forEach((task) => {
    addTaskEvents(task);
  });

  // Function to add event listeners to tasks (checkbox, dragstart, dragover, drop, dragend)
  function addTaskEvents(task) {
    // Handle disappearing tasks when checked
    const checkbox = task.querySelector("input[type='checkbox']");
    checkbox.addEventListener("change", () => {
      if (checkbox.checked) {
        task.remove(); // Remove task when checked
        createToast("Task Done: " + task.innerText.trim()); //Ver2 create toast after remove task
      }
    });

    // Add drag-and-drop event listeners
    task.addEventListener("dragstart", dragStart);
    task.addEventListener("dragover", dragOver);
    task.addEventListener("drop", dropTask);
    task.addEventListener("dragend", dragEnd);
  }

  // Drag-and-drop event handlers
  let draggedTask = null;

  function dragStart(event) {
    draggedTask = event.target;
    setTimeout(() => {
      event.target.style.display = "none"; // Make task invisible during drag
    }, 0);
  }

  function dragOver(event) {
    event.preventDefault(); // Necessary for allowing the drop
  }

  function dropTask(event) {
    event.preventDefault();
    const taskList = event.target.closest("ul");
    if (taskList && draggedTask) {
      taskList.appendChild(draggedTask); // Append task to new list
    }
  }

  function dragEnd(event) {
    setTimeout(() => {
      event.target.style.display = "block"; // Make task visible after drag
      draggedTask = null;
    }, 0);
  }

  // Make the task lists droppable by adding event listeners to each <ul>
  const taskLists = document.querySelectorAll(".task-list ul");
  taskLists.forEach((taskList) => {
    taskList.addEventListener("dragover", dragOver); // Allow tasks to be dragged over the list
    taskList.addEventListener("drop", dropTask); // Allow tasks to be dropped into the list
  });

  // Create Toast
  function createToast(message) {
    const toastContainer = document.querySelector(".notifications");
    if (!toastContainer) {
      console.error("Toast container not found!");
      return;
    }

    // Create a new toast element
    const toast = document.createElement("li");
    toast.className = "toast";

    // Setting the inner HTML for the toast
    toast.innerHTML = `<span>${message}</span> <i class="fa-solid fa-xmark" onclick="removeToast(this.parentElement)"></i>`;

    // Append the toast to the notifications container
    toastContainer.appendChild(toast);

    // Set a timer to remove the toast after 5 seconds
    setTimeout(() => removeToast(toast), 5000);
  }

  // Function to remove the toast after a certain time
  function removeToast(toast) {
    toast.classList.add("hide"); // Add a 'hide' class to the toast
    setTimeout(() => toast.remove(), 500); // Remove the toast from DOM after 500ms
  }
});
