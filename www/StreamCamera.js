var exec = require('cordova/exec');

exports.openCam = function (arg0, success, error) {
    exec(success, error, 'StreamCamera', 'openCam', [arg0]);
};

exports.Start = function (arg0, success, error) {
    exec(success, error, 'StreamCamera', 'Start', [arg0]);
};

