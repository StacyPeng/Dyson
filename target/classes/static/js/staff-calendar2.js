    //Auther：Hengqian Mao
    //c3008838
    /*========Calender Js=========*/
    /*==========================*/

    document.addEventListener("DOMContentLoaded", function () {
        /*=================*/
        //  Calender Date variable
        /*=================*/
        var newDate = new Date();
        function getDynamicMonth() {
            getMonthValue = newDate.getMonth();
            _getUpdatedMonthValue = getMonthValue + 1;
            if (_getUpdatedMonthValue < 10) {
                return `0${_getUpdatedMonthValue}`;
            } else {
                return `${_getUpdatedMonthValue}`;
            }
        }
        /*=================*/
        // Calender Modal Elements
        /*=================*/
        var getModalTitleEl = document.querySelector("#event-title");
        var getModalStartDateEl = document.querySelector("#event-start-date");
        var getModalEndDateEl = document.querySelector("#event-end-date");
        var getModalAddBtnEl = document.querySelector(".btn-add-event");
        var getModalUpdateBtnEl = document.querySelector(".btn-update-event");
        var calendarsEvents = {
            Danger: "danger",
            Success: "success",
            Primary: "primary",
            Warning: "warning",
        };
        /*=====================*/
        // Calendar load fn.
        /*=====================*/
        function splitDateTime(datetimeStr) {
            const date = new Date(datetimeStr);
            const datePart = date.toISOString().split('T')[0];
            const timePart = date.toTimeString().split(' ')[0].slice(0, 5);
            return { datePart, timePart };
        }

        var calendarEventClick = function (info) {
            var eventObj = info.event;
            var startDate = new Date(eventObj.start);
            var endDate = new Date(eventObj.end || eventObj.start);

            var formatDate = (date) => date.toISOString().split('T')[0];
            var formatTime = (date) => date.toTimeString().substring(0, 5);

            document.getElementById('event-title').value = eventObj.title;
            document.getElementById('event-start-date').value = formatDate(startDate);
            document.getElementById('event-start-time').value = formatTime(startDate);
            document.getElementById('event-end-date').value = formatDate(endDate);
            document.getElementById('event-end-time').value = formatTime(endDate);


            var eventColor = eventObj.extendedProps.calendar;
            if (eventColor) {
                document.querySelector(`input[name="event-level"][value="${eventColor}"]`).checked = true;
            }

            myModal.show();
        };



        function loadStaffCourses() {
            fetch('/api/courses/staff/courses')
                .then(response => response.json())
                .then(courses => {
                    console.log("Loaded courses:", courses);
                    courses.forEach(course => {
                        calendar.addEvent({
                            id: course.id,
                            title: course.title,
                            start: course.startTime,
                            end: course.endTime,
                            extendedProps: {
                                calendar: "Success"
                            }
                        });
                    });
                })
                .catch(error => console.error('Error loading courses:', error));
        }



        /*=====================*/
        // Calendar Elements and options
        /*=====================*/
        var calendarEl = document.querySelector("#calendar");
        var checkWidowWidth = function () {
            if (window.innerWidth <= 1199) {
                return true;
            } else {
                return false;
            }
        };
        var calendarHeaderToolbar = {
            left: "prev next addEventButton",
            center: "title",
            right: "dayGridMonth,timeGridWeek,timeGridDay",
        };
        var calendarEventsList = [
            {
                id: 1,
                title: "Event Conf.",
                start: `${newDate.getFullYear()}-${getDynamicMonth()}-01`,
                extendedProps: { calendar: "Danger" },
            },
            {
                id: 2,
                title: "Seminar #4",
                start: `${newDate.getFullYear()}-${getDynamicMonth()}-07`,
                end: `${newDate.getFullYear()}-${getDynamicMonth()}-10`,
                extendedProps: { calendar: "Success" },
            },
            {
                groupId: "999",
                id: 3,
                title: "Meeting #5",
                start: `${newDate.getFullYear()}-${getDynamicMonth()}-09T16:00:00`,
                extendedProps: { calendar: "Primary" },
            },
            {
                groupId: "999",
                id: 4,
                title: "Submission #1",
                start: `${newDate.getFullYear()}-${getDynamicMonth()}-16T16:00:00`,
                extendedProps: { calendar: "Warning" },
            },
            {
                id: 5,
                title: "Seminar #6",
                start: `${newDate.getFullYear()}-${getDynamicMonth()}-11`,
                end: `${newDate.getFullYear()}-${getDynamicMonth()}-13`,
                extendedProps: { calendar: "Danger" },
            },
            {
                id: 6,
                title: "Meeting 3",
                start: `${newDate.getFullYear()}-${getDynamicMonth()}-12T10:30:00`,
                end: `${newDate.getFullYear()}-${getDynamicMonth()}-12T12:30:00`,
                extendedProps: { calendar: "Success" },
            },
            {
                id: 7,
                title: "Meetup #",
                start: `${newDate.getFullYear()}-${getDynamicMonth()}-12T12:00:00`,
                extendedProps: { calendar: "Primary" },
            },
            {
                id: 8,
                title: "Submission",
                start: `${newDate.getFullYear()}-${getDynamicMonth()}-12T14:30:00`,
                extendedProps: { calendar: "Warning" },
            },
            {
                id: 9,
                title: "Attend event",
                start: `${newDate.getFullYear()}-${getDynamicMonth()}-13T07:00:00`,
                extendedProps: { calendar: "Success" },
            },
            {
                id: 10,
                title: "Project submission #2",
                start: `${newDate.getFullYear()}-${getDynamicMonth()}-28`,
                extendedProps: { calendar: "Primary" },
            },
        ];
        /*=====================*/
        // Calendar Select fn.
        /*=====================*/
        var calendarSelect = function (info) {
            getModalAddBtnEl.style.display = "block";
            getModalUpdateBtnEl.style.display = "none";
            myModal.show();
            getModalStartDateEl.value = info.startStr;
            getModalEndDateEl.value = info.endStr;
        };
        /*=====================*/
        // Calendar AddEvent fn.
        /*=====================*/
        var calendarAddEvent = function () {
            var currentDate = new Date();
            var dd = String(currentDate.getDate()).padStart(2, "0");
            var mm = String(currentDate.getMonth() + 1).padStart(2, "0"); //January is 0!
            var yyyy = currentDate.getFullYear();
            var combineDate = `${yyyy}-${mm}-${dd}T00:00:00`;
            getModalAddBtnEl.style.display = "block";
            getModalUpdateBtnEl.style.display = "none";
            myModal.show();
            getModalStartDateEl.value = combineDate;
        };

        /*=====================*/
        // Calender Event Function
        /*=====================*/
        var calendarEventClick = function (info) {
            var eventObj = info.event;

            document.getElementById('event-id').value = eventObj.id; // Store the id in the hidden input box

            var modId = eventObj.extendedProps.modId; // 确保你的事件对象中已经包含了modId
            document.getElementById('event-ModId').value = modId || ''; // Make sure your event object contains modId

            if (eventObj.url) {
                window.open(eventObj.url);

                info.jsEvent.preventDefault();
            } else {
                var getModalEventId = eventObj._def.publicId;
                var getModalEventLevel = eventObj._def.extendedProps["calendar"];
                var getModalCheckedRadioBtnEl = document.querySelector(
                    `input[value="${getModalEventLevel}"]`
                );

                getModalTitleEl.value = eventObj.title;
                getModalStartDateEl.value = eventObj.startStr.slice(0, 10);
                getModalEndDateEl.value = eventObj.endStr.slice(0, 10);
                getModalCheckedRadioBtnEl.checked = true;
                getModalUpdateBtnEl.setAttribute(
                    "data-fc-event-public-id",
                    getModalEventId
                );
                getModalAddBtnEl.style.display = "none";
                getModalUpdateBtnEl.style.display = "block";
                myModal.show();
            }
        };

        /*=====================*/
        // Active Calender
        /*=====================*/
        var calendar = new FullCalendar.Calendar(calendarEl, {
            selectable: true,
            height: checkWidowWidth() ? 900 : 1052,
            initialView: checkWidowWidth() ? "listWeek" : "dayGridMonth",
            initialDate: `${newDate.getFullYear()}-${getDynamicMonth()}-07`,
            headerToolbar: calendarHeaderToolbar,
            events: function(fetchInfo, successCallback, failureCallback) {
                fetch('/api/courses/staff/courses')
                    .then(response => {
                        if (!response.ok) {
                            throw new Error('Network response was not ok');
                        }
                        return response.json();
                    })
                    .then(events => {
                        console.log("Loaded courses:", events);// Output the obtained course data in the console
                        successCallback(events.map(event => ({
                            id: event.id,
                            title: event.title,
                            start: event.startTime,
                            end: event.endTime,
                            extendedProps: {
                                calendar: "Success",
                                modId: event.modId
                            }
                        })));
                    })
                    .catch(error => {
                        console.error('Error loading courses:', error);
                        failureCallback(error);
                    });
            },
            select: calendarSelect,
            unselect: function () {
                console.log("unselected");
            },
            customButtons: {
                addEventButton: {
                    text: "Add Event",
                    click: calendarAddEvent,
                },
            },
            eventClassNames: function ({ event: calendarEvent }) {
                const getColorValue =
                    calendarsEvents[calendarEvent._def.extendedProps.calendar];
                return ["event-fc-color fc-bg-" + getColorValue];
            },

            eventClick: calendarEventClick,
            windowResize: function (arg) {
                if (checkWidowWidth()) {
                    calendar.changeView("listWeek");
                    calendar.setOption("height", 900);
                } else {
                    calendar.changeView("dayGridMonth");
                    calendar.setOption("height", 1052);
                }
            },
        });

        /*=====================*/
        // Update Calender Event
        /*=====================*/
        getModalUpdateBtnEl.addEventListener("click", function () {
            var getPublicID = this.dataset.fcEventPublicId;
            var getTitleUpdatedValue = getModalTitleEl.value;
            var setModalStartDateValue = getModalStartDateEl.value;
            var setModalEndDateValue = getModalEndDateEl.value;
            var getEvent = calendar.getEventById(getPublicID);
            var getModalUpdatedCheckedRadioBtnEl = document.querySelector(
                'input[name="event-level"]:checked'
            );

            var getModalUpdatedCheckedRadioBtnValue =
                getModalUpdatedCheckedRadioBtnEl !== null
                    ? getModalUpdatedCheckedRadioBtnEl.value
                    : "";

            getEvent.setProp("title", getTitleUpdatedValue);
            getEvent.setDates(setModalStartDateValue, setModalEndDateValue);
            getEvent.setExtendedProp("calendar", getModalUpdatedCheckedRadioBtnValue);
            myModal.hide();
        });
        /*=====================*/
        // Add Calender Event
        /*=====================*/
        function addEvent() {
            const title = document.getElementById('event-title').value;
            const startTime = document.getElementById('event-start-time').value; // "HH:MM" format
            const endTime = document.getElementById('event-end-time').value; // "HH:MM" format
            const startDate = document.getElementById('event-start-date').value; // "YYYY-MM-DD" format
            const endDate = document.getElementById('event-end-date').value; // "YYYY-MM-DD" format
            const modId = document.getElementById('event-ModId').value;


            const fullStartTime = `${startDate}T${startTime}`;
            const fullEndTime = `${endDate}T${endTime}`;

            console.log('Fetched data:', fullStartTime);
            console.log('Fetched data:', fullEndTime);


            const eventData = {
                title: title,
                startTime: fullStartTime,
                endTime: fullEndTime,
                modId: modId

            };

            fetch('/api/courses', {
                method: 'POST', // or 'PUT' if updating an existing event
                headers: {
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify(eventData)
            })
                .then(response => response.json())
                .then(data => {

                    console.log('Success:', data);

                })
                .catch((error) => {
                    console.error('Error:', error);
                });
        }

        document.getElementById('addEventButton').addEventListener('click', function(event) {
            event.preventDefault(); // Block the button's default form submission behavior (if the button is in the form)
            addEvent(); // Call your function to handle the event
        });

        function updateEvent() {
            const eventId = document.getElementById('event-id').value; // Get the id from the hidden input box

            const title = document.getElementById('event-title').value;
            const startTime = document.getElementById('event-start-time').value;
            const endTime = document.getElementById('event-end-time').value;
            const startDate = document.getElementById('event-start-date').value;
            const endDate = document.getElementById('event-end-date').value;

            const fullStartTime = `${startDate}T${startTime}`;
            const fullEndTime = `${endDate}T${endTime}`;

            const eventData = {
                title: title,
                startTime: fullStartTime,
                endTime: fullEndTime,
            };

            fetch(`/api/courses/${eventId}`, {
                method: 'PUT',
                headers: {
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify(eventData)
            })
                .then(response => response.json())
                .then(data => {
                    console.log('Update Success:', data);
                    alert('Event updated successfully!');
                })
                .catch((error) => {
                    console.error('Update Error:', error);
                    alert('Failed to update event: ' + error.message);
                });
        }



        document.getElementById('updateEventButton').addEventListener('click', function() {
            const eventId = document.getElementById('event-id').value; // Make sure you have a way to get the ID of the event you are editing
            updateEvent(eventId);
        });


        function deleteEvent(eventId) {
            fetch(`/api/courses/${eventId}`, {
                method: 'DELETE'
            })
                .then(response => {
                    if (!response.ok) {
                        throw new Error('Failed to delete the event.');
                    }
                    return response.json();
                })
                .then(data => {
                    console.log('Delete Success:', data);
                    alert('Event deleted successfully!');
                    // You may need to update the page or remove some elements
                })
                .catch((error) => {
                    console.error('Delete Error:', error);
                    alert('Event deleted successfully!');
                });
        }

        document.getElementById('deleteButton').addEventListener('click', function() {
            const eventId = document.getElementById('event-id').value; // Make sure you have a way to get the ID of the event you are editing
            if (eventId && confirm("Are you sure you want to delete this event?")) { // Confirm the deletion operation
                deleteEvent(eventId);
            }
        });




        /*=====================*/
        // Calendar Init
        /*=====================*/
        calendar.render();
        var myModal = new bootstrap.Modal(document.getElementById("eventModal"));
        var modalToggle = document.querySelector(".fc-addEventButton-button ");
        document
            .getElementById("eventModal")
            .addEventListener("hidden.bs.modal", function (event) {
                getModalTitleEl.value = "";
                getModalStartDateEl.value = "";
                getModalEndDateEl.value = "";
                var getModalIfCheckedRadioBtnEl = document.querySelector(
                    'input[name="event-level"]:checked'
                );
                if (getModalIfCheckedRadioBtnEl !== null) {
                    getModalIfCheckedRadioBtnEl.checked = false;
                }
            });
    });