'use strict';

const request = require('request');

function getRandomInt(min, max) {
    min = Math.ceil(min);
    max = Math.floor(max);
    return Math.floor(Math.random() * (max - min + 1)) + min;
}

const NUM_MOVIES = 500;

for (const i of Array(NUM_MOVIES).keys()) {
    request.post('http://127.0.0.1:8080/api/movies', {
        json: {
            title: 'Movie' + i.toString(),
            year: getRandomInt(1900, 2010),
            genre: 'fantasy',
            director: 'Mr. Director',
            rating: NUM_MOVIES - i,
            description: 'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt' +
                ' ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris' +
                ' nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit' +
                ' esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt' +
                ' in culpa qui officia deserunt mollit anim id est laborum.'
        }},
        (error, response) => {
            if (error || response.statusCode !== 200) {
                console.log(response);
            } else {
                console.log('progress: ', i);
            }
        }
    );
}
