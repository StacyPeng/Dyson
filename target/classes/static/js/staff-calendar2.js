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
            const datePart = date.toISOString().split('T')[0]; // 获取日期部分
            const timePart = date.toTimeString().split(' ')[0].slice(0, 5); // 获取时间部分
            return { datePart, timePart };
        }

        var calendarEventClick = function (info) {
            var eventObj = info.event;
            var startDate = new Date(eventObj.start);
            var endDate = new Date(eventObj.end || eventObj.start); // 有的事件可能没有结束时间

            var formatDate = (date) => date.toISOString().split('T')[0];
            var formatTime = (date) => date.toTimeString().substring(0, 5);

            document.getElementById('event-title').value = eventObj.title;
            document.getElementById('event-start-date').value = formatDate(startDate);
            document.getElementById('event-start-time').value = formatTime(startDate);
            document.getElementById('event-end-date').value = formatDate(endDate);
            document.getElementById('event-end-time').value = formatTime(endDate);

            // 更新表单的颜色选择器
            var eventColor = eventObj.extendedProps.calendar;
            if (eventColor) {
                document.querySelector(`input[name="event-level"][value="${eventColor}"]`).checked = true;
            }

            myModal.show(); // 显示模态窗口
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
                                calendar: "Success"  // 如 "Danger", "Success" 等
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
                        console.log("Loaded courses:", events);// 在控制台输出获取的课程数据
                        successCallback(events.map(event => ({
                            id: event.id,
                            title: event.title,
                            start: event.startTime,
                            end: event.endTime,
                            extendedProps: {
                                calendar: "Success"  // 如 "Danger", "Success" 等
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
        getModalAddBtnEl.addEventListener("click", function () {
            var event = {
                title: getModalTitleEl.value,
                startTime: getModalStartDateEl.value + "T00:00:00",  // 假设所有事件从午夜开始
                endTime: getModalEndDateEl.value + "T23:59:59",  // 假设事件持续到午夜前一刻
                // 添加其他必要的字段，比如 teacher, room 等
            };

            fetch('/api/courses', {
                method: 'POST',
                headers: { 'Content-Type': 'application/json' },
                body: JSON.stringify(event)
            }).then(response => response.json())
                .then(data => {
                    calendar.addEvent({
                        id: data.id,  // 确保后端返回新创建的事件ID
                        title: data.title,
                        start: data.startTime,
                        end: data.endTime,
                        // 其他属性
                    });
                    myModal.hide();  // 隐藏模态框
                }).catch(error => console.error('Error:', error));
        });

        getModalUpdateBtnEl.addEventListener("click", function () {
            var eventId = this.getAttribute('data-fc-event-public-id'); // 获取事件ID
            var event = {
                title: getModalTitleEl.value,
                startTime: getModalStartDateEl.value + "T00:00:00",
                endTime: getModalEndDateEl.value + "T23:59:59",

            };

            fetch(`/api/courses/${eventId}`, {
                method: 'PUT',
                headers: { 'Content-Type': 'application/json' },
                body: JSON.stringify(event)
            }).then(response => {
                if (response.ok) {
                    // 更新日历视图上的事件信息
                    var calendarEvent = calendar.getEventById(eventId);
                    calendarEvent.setProp('title', event.title);
                    calendarEvent.setStart(event.startTime);
                    calendarEvent.setEnd(event.endTime);
                    // 更新其他属性
                    myModal.hide();  // 隐藏模态框
                }
            }).catch(error => console.error('Error:', error));
        });

        // // 假设您有一个删除按钮和监听器
        // getModalDeleteBtnEl.addEventListener("click", function () {
        //     var eventId = getModalUpdateBtnEl.getAttribute('data-fc-event-public-id'); // 获取事件ID
        //
        //     fetch(`/api/courses/${eventId}`, {
        //         method: 'DELETE'
        //     }).then(response => {
        //         if (response.ok) {
        //             // 从日历视图移除事件
        //             var calendarEvent = calendar.getEventById(eventId);
        //             calendarEvent.remove();
        //             myModal.hide();  // 隐藏模态框
        //         }
        //     }).catch(error => console.error('Error:', error));
        // });


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