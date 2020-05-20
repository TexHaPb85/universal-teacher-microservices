insert into auth_client_details (additional_information, id, client_id, client_secret, grant_types,  scopes)
    values ('browser test client', 'client1', 'browser', '$2a$10$fWNTd3H.u7G/aNROVQSifebOkZ2xzU5nUPOCI2Ld42M8E25/ljJqK',
            'refresh_token,password',  'ui');

insert into auth_client_details (additional_information, id, client_id, client_secret, grant_types,  scopes)
values ('service for accounts', 'ac', 'account-service', '$2a$10$fWNTd3H.u7G/aNROVQSifebOkZ2xzU5nUPOCI2Ld42M8E25/ljJqK',
        'refresh_token,client_credentials',  'server');

insert into auth_client_details (access_token_validity, additional_information,
                                 client_id, client_secret, grant_types, redirect_uris, refresh_token_validity, resources,
                                 scopes, id)
    values (null, 'some service2', 'UI', '$2a$10$fWNTd3H.u7G/aNROVQSifebOkZ2xzU5nUPOCI2Ld42M8E25/ljJqK',
            'refresh_token,password', null, null, null,
            'ui', 'client2');

