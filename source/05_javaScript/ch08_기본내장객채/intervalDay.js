// JavaScript source code(intervalDay.js)

Date.prototype.intervalDay = function (that) {
    if (this > that) { //this가 현재 ? 
        intervalMili = this.getTime() - that.getTime(); //get Time 밀리세컨 가져오는애
    } else {
        intervalMili = that.getTime() - this.getTime();
    }
    var day = intervalMili / (1000 * 60 * 60 * 24)   // 1000만하면 초   * 60하면 분
    return Math.trunc(day);
};