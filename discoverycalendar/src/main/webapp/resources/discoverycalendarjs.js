var discoveryCalendarJS = (function ($) {
    var self = this;
    
    self.campuses = [ 'Central Campus', 'East Campus', 'Southwest Campus'];
    self.ministries = [ 'DC 20-30s', 'DC Arts', 'DC Care', 'Classes', 'DC Group Life', 'DC Kids', 'DC Men', 'DC On Mission', 'DC Students', 'DC Women' ];
    self.campusMinistryPlans = {};
    
    self.resetPlans = function() {
        self.campusMinistryPlans = {
            'Central Campus' : {
                'DC 20-30s' : {}, 
                'DC Arts' : {}, 
                'DC Care' : {}, 
                'Classes' : {}, 
                'DC Group Life' : {}, 
                'DC Kids' : {}, 
                'DC Men' : {}, 
                'DC On Mission' : {}, 
                'DC Students' : {}, 
                'DC Women' : {}
            },
            'East Campus' : {
                'DC 20-30s' : {}, 
                'DC Arts' : {}, 
                'DC Care' : {}, 
                'Classes' : {}, 
                'DC Group Life' : {}, 
                'DC Kids' : {}, 
                'DC Men' : {}, 
                'DC On Mission' : {}, 
                'DC Students' : {}, 
                'DC Women' : {}
            },
            'Southwest Campus' : {
                'DC 20-30s' : {}, 
                'DC Arts' : {}, 
                'DC Care' : {}, 
                'Classes' : {}, 
                'DC Group Life' : {}, 
                'DC Kids' : {}, 
                'DC Men' : {}, 
                'DC On Mission' : {}, 
                'DC Students' : {}, 
                'DC Women' : {}
            }
        };
    };
    
    self.getCampuses = function() {
        return self.campuses;
    };
    
    self.getMinistries = function() {
        return self.ministries;
    };
    
    self.getPlansForCampusMinistry = function(campus, ministry) {
        var data = [];
        
        for (var x = 0; x < self.campuses.length; x++) {
            if (campus === "All" || self.campuses[x] === campus) {
                for (var y = 0; y < self.ministries.length; y++) {
                    if (ministry === "All" || self.ministries[y] === ministry) {
                        var subdata = self.campusMinistryPlans[self.campuses[x]][self.ministries[y]];
                        for (var z = 0; z < subdata.length; z++) {
                            data.push(subdata[z]);
                        }
                    }
                }
            }
        }
        
        return data;
    };
    
    self.getAllPlans = function() {
        var data = [];
        
        for (var x = 0; x < self.campuses.length; x++) {
            for (var y = 0; y < self.ministries.length; y++) {
                var subdata = self.campusMinistryPlans[self.campuses[x]][self.ministries[y]];
                for (var z = 0; z < subdata.length; z++) {
                    data.push(subdata[z]);
                }
            }
        }
        
        return data;
    };
    
    self.loadPlansForCampusAndMinistry = function (campus, ministry) {
        $.ajax({
            method: 'GET',
            url: '/discoverycalendar/api/plans/' + campus + '/' + ministry,
            cache: false,
            dataType: 'json',
            async: false
        })
        .done(function(data, textStatus, jqXHR) {
            self.campusMinistryPlans[campus][ministry] = data;
        })
        .fail(function(jqXHR, textStatus, errorThrown) {
            alert('Could not load event information for ' + campus + ' - ' + ministry);
        });
    };
    
    self.loadPlans = function() {
        self.resetPlans();
        
        for (var x = 0; x < self.campuses.length; x++) {
            for (var y = 0; y < self.ministries.length; y++) {
                self.loadPlansForCampusAndMinistry(self.campuses[x], self.ministries[y]);
            }
        }
    };

    return {
        loadPlans: self.loadPlans,
        getAllPlans: self.getAllPlans,
        getCampuses: self.getCampuses,
        getMinistries: self.getMinistries,
        getPlansForCampusMinistry: self.getPlansForCampusMinistry
    };
})(jQuery);

