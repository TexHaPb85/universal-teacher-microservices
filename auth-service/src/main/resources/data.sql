insert into auth_client_details (access_token_validity, additional_information, client_id, client_secret, grant_types, redirect_uris, refresh_token_validity, resources, scopes, id)
    values (null, 'some service', 'browser', '$2a$10$fWNTd3H.u7G/aNROVQSifebOkZ2xzU5nUPOCI2Ld42M8E25/ljJqK','refresh_token,password', null, null, null, 'ui', 'client1');

insert into user (activated, activation_key, password, reset_password_key, username, id)
    values (true, 'null', '$2a$10$fWNTd3H.u7G/aNROVQSifebOkZ2xzU5nUPOCI2Ld42M8E25/ljJqK', 'null', 'randomuser', 'u1');

insert into auth_client_details (access_token_validity, additional_information, client_id, client_secret, grant_types, redirect_uris, refresh_token_validity, resources, scopes, id)
    values (null, 'some service2', 'browser', '$2a$10$fWNTd3H.u7G/aNROVQSifebOkZ2xzU5nUPOCI2Ld42M8E25/ljJqK', 'refresh_token,password', null, null, null, 'ui', 'client2');

insert into user (activated, activation_key, password, reset_password_key, username, id)
    values (true, 'null', '$2a$10$fWNTd3H.u7G/aNROVQSifebOkZ2xzU5nUPOCI2Ld42M8E25/ljJqK', 'null', 'randomuser2', 'u2');

