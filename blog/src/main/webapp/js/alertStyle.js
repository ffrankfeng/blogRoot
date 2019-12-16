window.alert = function (message, title, callbak) {
    /// <summary>
    /// 关闭Alert弹出窗
    /// </summary>
    (closeAlert = function () { $('#alert-window').remove(); })();
    var bg = $('<div class="alert-bg"></div>');
    var wnd = $('<div class="alert-wnd"><div class="alert-head"><center>'
                + (title || "提示信息")
                + '</center></div><div class="alert-body"><div class="alert-msg"><p>'
                + (message || '') + '</p></div><div class="alert-icon"></div></div><div class="alert-footer"><a class="alert_btn btn-small" id="alert-confirm">确认</a>&nbsp;&nbsp;&nbsp;<a class="alert_btn btn-small" id="alert-confirm">取消</a></div></div>');
    window.top.$(document.body).append($('<div id="alert-window"></div>').append(bg).append(wnd).delegate('#alert-confirm', 'click', function () { closeAlert(); callbak && callbak(); }));
};