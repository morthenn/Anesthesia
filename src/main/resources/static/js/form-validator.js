$(document).ready(function() {
    $('#contact_form').bootstrapValidator({
        // To use feedback icons, ensure that you use Bootstrap v3.1.0 or later
        feedbackIcons: {
            valid: 'glyphicon glyphicon-ok',
            invalid: 'glyphicon glyphicon-remove',
            validating: 'glyphicon glyphicon-refresh'
        },
        fields: {
            evidential_number: {
            number: {
            validators: {
                  numeric: {
                      message: 'Nie podałaś liczby'
                         },
                  notEmpty: {
                      message: 'Musisz wypełnić to pole'
                  }
                }
              }
             },
            patientAge: {
            number: {
            validators: {
                  numeric: {
                       message: 'Nie podałaś liczby'
                          },
                  notEmpty: {
                       message: 'Musisz wypełnić to pole'
                       }
                   }
               }
            },
            asaFactor: {
                validators: {
                    notEmpty: {
                        message: 'Musisz coś wybrać z listy'
                    }
                }
            },
            anesthesiaTechnique: {
                validators: {
                    notEmpty: {
                        message: 'Musisz coś wybrać'
                    }
                }
            },
            supervisionType: {
                validators: {
                    notEmpty: {
                        message: 'Musisz coś wybrać'
                    }
                }
            },
            treatmentType: {
                validators: {
                     stringLength: {
                        min: 3,
                    },
                    notEmpty: {
                        message: 'Coś tutaj musisz wpisać:)'
                    }
                }
            }
          }
        })

        .on('success.form.bv', function(e) {
            $('#success_message').slideDown({ opacity: "show" }, "slow") // Do something ...
                $('#contact_form').data('bootstrapValidator').resetForm();

            // Prevent form submission
             e.preventDefault();

            // Get the form instance
            var $form = $(e.target);

            // Get the BootstrapValidator instance
            var bv = $form.data('bootstrapValidator');

            // Use Ajax to submit form data
            $.post($form.attr('action'), $form.serialize(), function(result) {
                console.log(result);
            }, 'json');

        });
});