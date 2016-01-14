window.onload = function () {
    var isbn = getQueryParam('isbn');
    if (isbn) {
      $.ajax({
        type: "GET",
        url: baseUrl + "/" + isbn,
        dataType: 'json',
        success: function (book) {
          for (var key in tableHeaderMapper) {
            document.querySelector('input[name="' + key + '"]').value = book[tableHeaderMapper[key]];
          }
          var isbnInput = document.querySelector('input[name="ISBN"]');
          isbnInput.disabled = true;
        }
      });
    }

    var form = document.querySelector('.form');
    form.addEventListener('submit', function (e) {
        e.preventDefault();
        var formElements = e.target.elements;
        var book = {};
        for (var i = 0; i < formElements.length - 1; ++i) {
            book[tableHeaderMapper[formElements[i].name]] = formElements[i].value;
        }
        if (isbn) {
          $.ajax({
            type: "PUT",
            url: baseUrl + "/" + isbn,
            data: JSON.stringify(book),
            contentType: "application/json; charset=utf-8",
            success: function () {
              location.href = '/index.html';
            }
          });
        } else {
            $.ajax({
                type: "POST",
                url: baseUrl,
                data: JSON.stringify(book),
                contentType: "application/json; charset=utf-8",
                success: function () {
                    location.href = '/index.html';
                }
            });
        }
    });
};
