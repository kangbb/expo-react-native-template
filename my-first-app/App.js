import React from 'react';
import { AppContainer } from "./target/my-first-app.core";

// CRNA expects a App.js with an App export
// without a framework that would be too much manual code to write
// since CLJS doesn't have class extends, so we just do it this way

// reagent and others would make this file optional
export default function App() {
  return (
    <AppContainer />
  )
}
