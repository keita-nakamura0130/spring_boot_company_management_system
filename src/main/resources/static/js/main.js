$(function () {
  $('#birthday').datepicker({
    dateFormat: 'yy/mm/dd', // フォーマット
    changeYear: true, // 年を表示
    changeMonth: true, // 月を選択
    showButtonPanel: true, // 閉じるボタン
    });
  $('#joinDate').datepicker({
    dateFormat: 'yy/mm/dd', // フォーマット
    changeYear: true, // 年を表示
    changeMonth: true, // 月を選択
    showButtonPanel: true, // 閉じるボタン
    });
  $('#retirementDate').datepicker({
    dateFormat: 'yy/mm/dd', // フォーマット
    changeYear: true, // 年を表示
    changeMonth: true, // 月を選択
    showButtonPanel: true, // 閉じるボタン
    });
});
