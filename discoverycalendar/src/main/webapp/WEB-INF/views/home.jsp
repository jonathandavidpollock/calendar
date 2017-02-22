<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Discovery Church Calendar</title>
        <link href='//cdnjs.cloudflare.com/ajax/libs/fullcalendar/3.1.0/fullcalendar.min.css' rel='stylesheet' />
        <link href='//cdnjs.cloudflare.com/ajax/libs/fullcalendar/3.1.0/fullcalendar.print.css' rel='stylesheet' media='print' />
        <link href='https://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css' rel='stylesheet' />
        <link href='/discoverycalendar/resources/style.css' rel='stylesheet'>
        <script src='//cdnjs.cloudflare.com/ajax/libs/moment.js/2.17.1/moment.min.js'></script>
        <script src='https://code.jquery.com/jquery-3.1.1.min.js' integrity='sha256-hVVnYaiADRTO2PzUGmuLJr8BLUSjGIZsDYGmIJLv2b8=' crossorigin='anonymous'></script>
        <script src='http://code.jquery.com/ui/1.12.1/jquery-ui.min.js' integrity='sha256-VazP97ZCwtekAsvgPBSUwPFKdrwD3unUfSGVYrahUqU=' crossorigin='anonymous'></script>
        <script src='//cdnjs.cloudflare.com/ajax/libs/fullcalendar/3.1.0/fullcalendar.min.js'></script>
        <script src='/discoverycalendar/resources/discoverycalendarjs.js'></script>
    </head>
    <body>
        <div>
            Campus Filter:<select id='campus_filter'></select>     Ministry Filter:<select id='ministry_filter'></select>
        </div>
        <div id='calendar'></div>
        <div id='progress'></div>
        <script type="text/javascript">
            function swapPlans(campus, ministry) {
                var events = discoveryCalendarJS.getPlansForCampusMinistry(campus,ministry);
                $('#calendar').fullCalendar('removeEvents');
                $('#calendar').fullCalendar('renderEvents', events, true);
            }
            
            $(document).ready(function() {
                
                var campuses = discoveryCalendarJS.getCampuses();
                var ministries = discoveryCalendarJS.getMinistries();
                
                $('#campus_filter').append($("<option></option>").attr("value", 0).text("All"));
                $('#ministry_filter').append($("<option></option>").attr("value", 0).text("All"));
                
                for (var x = 1; x <= campuses.length; x++) {
                    $('#campus_filter').append($("<option></option>").attr("value", x).text(campuses[x-1]));
                }
                
                for (var x = 1; x <= ministries.length; x++) {
                    $('#ministry_filter').append($("<option></option>").attr("value", x).text(ministries[x-1]));
                }
                
                var sel_campus = "All";
                var sel_ministry = "All";
                
                $('#campus_filter').on('change', function() {
                    var val = parseInt(this.value);
                    
                    if (val === 0) {
                        sel_campus = "All";
                    }
                    else {
                        sel_campus = campuses[val - 1];
                    }
                    swapPlans(sel_campus, sel_ministry);
                });
                
                $('#ministry_filter').on('change', function() {
                    var val = parseInt(this.value);
                    if (val === 0) {
                        sel_ministry = "All";
                    }
                    else {
                        sel_ministry = ministries[val - 1];
                    }
                    swapPlans(sel_campus, sel_ministry);
                });
                
                $('#calendar').fullCalendar({
                    height: $(window).height()*0.83,
                    header: {
                        left: 'prev,next today',
                        center: 'title',
                        right: 'month,basicWeek,basicDay'
                    },
                    navLinks: true,
                    editable: false,
                    eventLimit: true,
                    eventMouseover: function(calEvent, jsEvent, view) {
                        $(jsEvent.target).css('cursor', 'pointer');
                    },
                    eventClick: function(calEvent, jsEvent, view) {
                        $('#calendar').fullCalendar('gotoDate', calEvent.start);
                        $('#calendar').fullCalendar('changeView', 'basicDay');
                    },
                    events: []
                });
                
                $('#progress').dialog({
                    hide: 'slide',
                    show: 'slide',
                    autoOpen: false,
                    closeOnEscape: false,
                    open: function (event, ui) {
                        $('.ui-dialog-titlebar-close', ui.dialog | ui).hide();
                    }
                });
                
                $('#progress').dialog('open').html('<p>Loading calendar...</p>');
                
                setTimeout(function() {
                    discoveryCalendarJS.loadPlans();
                    var events = discoveryCalendarJS.getAllPlans();
                    $('#calendar').fullCalendar('renderEvents', events, true);
                    $('#progress').dialog('close');
                }, 2000);
            });
            
            $(window).resize(function() {
                var calHeight = $(window).height()*0.83;
                $('#calendar').fullCalendar('option', 'height', calHeight);
            });
        </script>
    </body>
</html>
