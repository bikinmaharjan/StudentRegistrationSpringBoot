$(document).ready(function () {
  $('#myInput').on('keyup', function () {
    var value = $(this).val().toLowerCase();
    $('#studentTable tr').filter(function () {
      $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1);
    });
  });
  $.ajax({
    type: 'GET',
    url: 'http://localhost:9999/students',
    success: function (studentArray) {
      var studentsDiv = $('tbody#studentTable');

      $.each(studentArray, function (index, student) {
        var studentInfo = '<tr class="">';

        studentInfo += '<td >' + student.id + '</td>';
        studentInfo += '<td >' + student.name + '</td>';
        studentInfo += '<td >' + student.age + '</td>';
        studentInfo += '<td >' + student.mobileNumber + '</td>';
        studentInfo += '<td >' + student.address + '</td>';
        studentInfo += '</tr>';

        studentsDiv.append(studentInfo);
      });
    },
    error: function () {
      alert('FAILURE!');
    },
  });
  $('button#findbyid').click(function () {
    var id = $('#findId').val();
    $.ajax({
      type: 'GET',
      url: 'http://localhost:9999/students/' + id,
      success: function (student) {
        if (student.length == 0) {
          alert('No Student with that ID');
        } else {
          var studentByIdDiv = $('div#studentById');
          var studentInfo = '<ul class=" bg-warning">';
          studentInfo +=
            '<li class="list-group-item active">ID: ' + student.id + '</li>';
          studentInfo +=
            '<li class="list-group-item">Name: ' + student.name + '</li>';
          studentInfo +=
            '<li class="list-group-item">Age: ' + student.age + '</li>';
          studentInfo +=
            '<li class="list-group-item">Mobile Number: ' +
            student.mobileNumber +
            '</li>';
          studentInfo +=
            '<li class="list-group-item">Address: ' + student.address + '</li>';
          studentInfo += '</ul>';

          studentByIdDiv.prepend(studentInfo);
        }
      },
    });
  });
  $('button#deletebyid').click(function () {
    var id = $('#deletebyid').val();
    $.ajax({
      type: 'DELETE',
      url: 'http://localhost:9999/students/' + id,
      success: function (student) {
        alert('Student with ID ' + id + ' deleted from DB');
        location.reload(true);
      },
    });
  });
  $('#studentform').submit(function (e) {
    e.preventDefault(); // avoid to execute the actual submit of the form.
    function getFormData($form) {
      var unindexed_array = $form.serializeArray();
      var indexed_array = {};

      $.map(unindexed_array, function (n, i) {
        indexed_array[n['name']] = n['value'];
      });

      return indexed_array;
    }

    var $form = $('#studentform');
    var dataJson = getFormData($form);
    console.log(dataJson);
    $.ajax('http://localhost:9999/students', {
      data: JSON.stringify(dataJson),
      type: 'POST',
      processData: false,
      contentType: 'application/json',
      success: function (student) {
        var studentsDiv = $('tbody#studentTable');
        var studentInfo = '<tr class="bg-success">';

        studentInfo += '<td >' + student.id + '</td>';
        studentInfo += '<td >' + student.name + '</td>';
        studentInfo += '<td >' + student.age + '</td>';
        studentInfo += '<td >' + student.mobileNumber + '</td>';
        studentInfo += '<td >' + student.address + '</td>';
        studentInfo += '</tr>';

        studentsDiv.prepend(studentInfo);
      },
    });
  });
});
