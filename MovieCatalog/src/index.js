import React from 'react';
import ReactDOM from 'react-dom';
import App from './components/App';
import {createStore} from 'redux';
import reducers from './reducers';
import {Provider} from 'react-redux';
import {getStoredState, createPersistor} from 'redux-persist';

getStoredState({}, (err, restoredState) => {
    const store = createStore(reducers, restoredState);
    createPersistor(store, {});
    ReactDOM.render(<Provider store={store}><App/></Provider>, document.getElementById('root'));
})