// JavaScript source code(intervalDay.js)

Date.prototype.intervalDay = function (that) {
    if (this > that) { //this�� ���� ? 
        intervalMili = this.getTime() - that.getTime(); //get Time �и����� �������¾�
    } else {
        intervalMili = that.getTime() - this.getTime();
    }
    var day = intervalMili / (1000 * 60 * 60 * 24)   // 1000���ϸ� ��   * 60�ϸ� ��
    return Math.trunc(day);
};