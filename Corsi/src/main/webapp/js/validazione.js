$(document).ready(function() {
	$('#form').bootstrapValidator({ 
		feedbackIcons: {
			valid: 'glyphicon glyphicon-ok',
			invalid: 'glyphicon glyphicon-remove',
			validating: 'glyphicon glyphicon-refresh'
		},
		fields: {
			course_name: {
				container: '#infoCourseName',
				validators: {
					notEmpty: { 
						message: 'Il campo nome non può essere vuoto' 
					},
					regexp: { 
						regexp: /^[a-zA-Z0-9 ]{2,30}$/, 
						message: 'Da 2 a 30 caratteri (Solo lettere e numeri)' 
					}
				}
			},
			name: {
				container: '#infoStudentName',
				validators: {
					notEmpty: { 
						message: 'Il campo nome non può essere vuoto' 
					},
					regexp: { 
						regexp: /^[a-zA-Z]{2,30}$/, 
						message: 'Da 2 a 30 caratteri (Solo lettere)' 
					}
				}
			},
			surname: {
				container: '#infoStudentSurname',
				validators: {
					notEmpty: { 
						message: 'Il campo cognome non può essere vuoto' 
					},
					regexp: { 
						regexp: /^[a-zA-Z]{2,30}$/, 
						message: 'Da 2 a 30 caratteri (Solo lettere)' 
					}
				}
			},
			username: {
				container: '#infoUsername',
				validators: {
					notEmpty: { 
						message: 'Il campo username non può essere vuoto' 
					},
					regexp: { 
						regexp: /^[a-z]{2,20}$/, 
						message: 'Da 2 a 20 caratteri (Solo lettere minuscole)' 
					}
				}
			},
			admincode: {
				container: '#infoAdminCode',
				validators: {
					notEmpty: { 
						message: 'Il campo codice admin non può essere vuoto' 
					},
					regexp: { 
						regexp: /^[a-zA-Z0-9]{5,30}$/, 
						message: 'Da 5 a 30 caratteri'
					}
				}
			},
			coursename: {
				container: '#infoCourseName',
				validators: {
					notEmpty: { 
						message: 'Il campo nome corso non può essere vuoto' 
					},
					regexp: { 
						regexp: /^[a-zA-Z]{2,30}$/, 
						message: 'Da 2 a 30 caratteri (Solo lettere)' 
					}
				}
			},
			startdate: {
				container: '#infoStartDate',
				validators: {
					notEmpty: {
						message: 'Il campo Data di nascita non può essere vuoto'
					},
					date: {
						format: 'DD/MM/YYYY',
						message: 'Inserire una data valida. Formato GG/MM/AAAA'
					}
				}
			},
			enddate: {
				container: '#infoEndDate',
				validators: {
					notEmpty: {
						message: 'Il campo Data di nascita non può essere vuoto'
					},
					date: {
						format: 'DD/MM/YYYY',
						message: 'Inserire una data valida. Formato GG/MM/AAAA'
					}
				}
			},
			comment: {
				container: '#infoComment',
				validators: {
					notEmpty: { 
						message: 'Il campo commento non può essere vuoto' 
					},
					regexp: {
						regexp: /^[a-zA-Z0-9.-]{2,200}$/,
						message: 'Max 200 caratteri (Lettere, numeri e . o -)'
					}
				}
			},
			classroom: {
				container: '#infoClassroom',
				validators: {
					notEmpty: { 
						message: 'Il campo aula non può essere vuoto' 
					},
					regexp: {
						regexp: /^[a-zA-Z0-9]{2,30}$/,
						message: ''
					}
				}
			},
			cost: {
				container: '#infoCost',
				validators: {
					notEmpty: { 
						message: 'Il campo costo non può essere vuoto' 
					},
					regexp: { 
						regexp: /^[0-9]{1,30}$/, 
						message: '' 
					}
				}
			},
		} 
	});
});