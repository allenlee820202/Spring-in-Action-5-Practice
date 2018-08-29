var designForm = {
    'ingredients': $('input[name="ingredients"]:checked').valueOf(),
    'tacoName': $('#tacoName').valueOf(),
    '_csrf': $('#_csrf').valueOf()
};
var ajaxSetting = $.ajax({
    url: "/design",
    type: "POST",
    data: designForm
});
