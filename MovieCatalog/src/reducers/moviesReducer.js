import {combineReducers} from 'redux';
import {REHYDRATE} from 'redux-persist/constants';
import {movies} from '../movies.json';

function favourites(state = [], action) {
    let newState, index;
    switch (action.type) {
    case 'ADD_TO_FAVOURITES':
        if (state.includes(action.id)) {
            return state;
        }
        return [...state, action.id];
    case 'REMOVE_FROM_FAVOURITES':
        index = state.indexOf(action.id);
        if (index == -1) {
            return state;
        }
        newState = [...state];
        newState.splice(index, 1);
        return newState;
    case 'CHANGE_ORDER':
        console.log("current state ", state);
        index = state.indexOf(action.id);
        let newIndex = index + action.value;
        if (index < 0 || newIndex < 0 || state.length <= newIndex) {
            return state;
        }
        newState = [...state];

        [newState[index], newState[newIndex]] = [newState[newIndex], newState[index]]
        console.log("newState " + newState);
        return newState;
    default:
        return state;
    }
}

function nonFavourites(state, action) {
    if (!state) {
        return movies.map(movie => movie.id);
    }
    switch (action.type) {
    case 'REMOVE_FROM_FAVOURITES':
        if (state.includes(action.id)) {
            return state;
        }
        return [...state, action.id];
    case 'ADD_TO_FAVOURITES':
        let index = state.indexOf(action.id);
        if (index == -1) {
            return state;
        }
        let newState = [...state];
        newState.splice(index, 1);
        return newState;
    default:
        return state;
    }
}

function all(state = [], action) {
    console.log(movies);
    return movies;
}

export default combineReducers({all, favourites, nonFavourites});