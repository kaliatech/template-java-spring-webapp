//global shims and small scripts

// Date.now shim ...already exists in ECMA 1.5+
Date.now = Date.now || function() {
  return new Date().getTime();
};

//console.log shim ...prevent errors when console.log doesn't exist
if (typeof console === "undefined"){
  console = function(){
    this.log = function(){
      return;
    }
  }
}