/*function onYouTubeIframeAPIReady(){
  var e=document.getElementById("youtube-audio"),t=document.createElement("img");
  t.setAttribute("id","youtube-icon"),t.style.cssText="cursor:pointer;cursor:hand",e.appendChild(t);
  var a=document.createElement("div");
  a.setAttribute("id","youtube-player"),e.appendChild(a);
  var o=function(e){
    var a=e?"IDzX9gL.png":"quyUPXN.png";
    t.setAttribute("src","https://i.imgur.com/"+a);
    t.setAttribute("height",40);
    t.setAttribute("width",40);
    t.setAttribute("align",middle);}

    e.onclick=function(){
      r.getPlayerState()===YT.PlayerState.PLAYING||r.getPlayerState()===YT.PlayerState.BUFFERING?(r.pauseVideo(),o(!1)):(r.playVideo(),o(!0));}

      var r=new YT.Player("youtube-player",{height:"100",width:"100",videoId:e.dataset.video,playerVars:{autoplay:e.dataset.autoplay,loop:e.dataset.loop},events:{onReady:function(e){
        r.setPlaybackQuality("small"),o(r.getPlayerState()!==YT.PlayerState.CUED)},onStateChange:function(e){
          e.data===YT.PlayerState.ENDED&&o(!1)}
        }
      }
    );

    r.loadVideoById({'-BjZmE2gtdo'});
}
    function reloadPlayer(v){
      r.loadVideoById({v});
    }
*/
var r;
var t;
var p;

function onYouTubeIframeAPIReady(){
  var e = document.getElementById("youtube-audio");

  t = document.createElement("img");
  t.setAttribute("id","youtube-icon");
  t.setAttribute("src","https://i.imgur.com/IDzX9gL.png");
  t.setAttribute("height",40);
  t.setAttribute("width",40);
  t.style.cssText="cursor:pointer;cursor:hand";
  e.appendChild(t);

  p = document.createElement("div");
  p.setAttribute("id","player1");
  e.appendChild(p);

  r = new YT.Player("player1",{height:"100",width:"100",videoId:"ktvTqknDobU",events:{onReady:onPlayerReady,onStateChange:onPlayerStateChange}});

  t.onclick = function(){
    if(r.getPlayerState()===YT.PlayerState.PLAYING){
      r.pauseVideo();
      t.setAttribute("src","https://i.imgur.com/quyUPXN.png");
      return;
    }
    if(r.getPlayerState()===YT.PlayerState.BUFFERING || r.getPlayerState()===YT.PlayerState.PAUSED || r.getPlayerState().CUED){
      r.playVideo();
      t.setAttribute("src","https://i.imgur.com/IDzX9gL.png");
      return;
    }
  }

}

function onPlayerStateChange(event){
  if (event.data == YT.PlayerState.PLAYING && !done) {
          setTimeout(r.stopVideo(), 6000);
          done = true;
        }
}

function onPlayerReady(event){
  //event.target.playVideo();
}

function reloadPlayer(x){
  r.loadVideoById(x);
}
