/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
 var caja;
if (typeof exports === 'object') {

    var joint = {
        util: require('../src/core').util,
        shapes: {
            basic: require('./joint.shapes.basic')
        },
        dia: {
            ElementView: require('../src/joint.dia.element').ElementView,
            Link: require('../src/joint.dia.link').Link
        }
    };
    var _ = require('lodash');
}

joint.shapes.arbol = {};

joint.shapes.arbol.Model = joint.shapes.basic.Generic.extend(_.extend({}, joint.shapes.basic.PortsModelInterface, {

    markup: '<g class="rotatable"><g class="scalable"><rect class="body"/><image class="img" />  </g><text class="label"/><g class="inPorts"/><g class="outPorts"/></g>',
    portMarkup: '<g class="port port<%= id %>"><circle class="port-body"/><text class="port-label"/></g>',

    defaults: joint.util.deepSupplement({

        type: 'arbol.Model',
        size: { width: 1, height: 1 },
        
        inPorts: [],
        outPorts: [],

        attrs: {
            '.': { magnet: false },
            '.body': {
                width: 80, height: 80,
                stroke: '#000000'
            },
            '.port-body': {
                r: 10,
                magnet: true,
                stroke: '#000000'
            },
            text: {
                'pointer-events': 'none'
            },
            '.label': { text: 'Model', 'ref-x': .5, 'ref-y': 10, ref: '.body', 'text-anchor': 'middle', fill: '#000000' },
            '.inPorts .port-label': { x:37, dy: -5, 'text-anchor': 'end', fill: '#000000' },
            '.outPorts .port-label':{ x: 17, dy: -7, fill: '#000000' }
        }

    }, joint.shapes.basic.Generic.prototype.defaults),

    getPortAttrs: function(portName, index, total, selector, type) {

        var attrs = {};

        var portClass = 'port' + index;
        var portSelector = selector + '>.' + portClass;
        var portLabelSelector = portSelector + '>.port-label';
        var portBodySelector = portSelector + '>.port-body';

        attrs[portLabelSelector] = { text: portName };
        attrs[portBodySelector] = { port: { id: portName || _.uniqueId(type) , type: type } };
        attrs[portSelector] = { ref: '.body', 'ref-x': (index + 0.5) * (1 / total) };

        if (selector === '.inPorts') { attrs[portSelector]['ref-dy'] = 2; }
        if (selector === '.outPorts') { attrs[portSelector]['ref-y'] = -23; }
        
        

        return attrs;
    }
}));


joint.shapes.arbol.Model.prototype.setIdModel=function(id){
    console.log("dentro del modelo");
    console.log(id.target);
    this.id=id;
//this.model.id=id;

};




/*
joint.shapes.arbol.Evento = joint.shapes.arbol.Model.extend({
    defaults: joint.util.deepSupplement({
        type: 'arbol.Evento',
        attrs: {
            rect: { stroke: 'none', 'fill-opacity': 0 },
            '.inPorts .port-body': { fill: 'PaleGreen' },
            '.outPorts .port-body': { fill: 'Tomato' }
        }
    }, joint.shapes.basic.Rect.prototype.defaults)
    });
    */
    
joint.shapes.arbol.Evento=joint.shapes.arbol.Model.extend({
    defaults: joint.util.deepSupplement({

        type: 'arbol.Evento',
        size: { width: 170, height: 100 },
        attrs: {           
            '.label': { text: '' },            
            '.inPorts .port-body': { fill: 'PaleGreen' },
            '.outPorts .port-body': { fill: 'Tomato' }
        }

    }, joint.shapes.arbol.Model.prototype.defaults),
    getPortAttrs: function(portName, index, total, selector, type) {

        var attrs = {};

        var portClass = 'port' + index;
        var portSelector = selector + '>.' + portClass;
        var portLabelSelector = portSelector + '>.port-label';
        var portBodySelector = portSelector + '>.port-body';

        attrs[portLabelSelector] = { text: portName };
        attrs[portBodySelector] = { port: { id: portName || _.uniqueId(type) , type: type } };
        attrs[portSelector] = { ref: '.body', 'ref-x': (index + 0.5) * (1 / total) };

        if (selector === '.inPorts') { attrs[portSelector]['ref-dy'] = 2; }
        if (selector === '.outPorts') { attrs[portSelector]['ref-y'] = -10; }       
       return attrs;
    }
    });


//joint.shapes.arbol.Model.Evento.type='arbol.Model.Evento';
var ARBOL = ARBOL || {};
ARBOL.Compuerta = function (id,type) {
    this.id=id;
    this.val=0;
    this.hijosEventos=new Array();
    this.hijosCompuertas=new Array();
    this.type=type;
    this.Compuerta;
};


joint.shapes.arbol.CompuertaAND = joint.shapes.arbol.Model.extend({

    defaults: joint.util.deepSupplement({

        type: 'arbol.CompuertaAND',
        size: { width: 80, height: 80 },
        attrs: {
            '.body': { fill: 'salmon' },
            '.label': { text: '' },
             image: { 
                width:80,
                height:80,
                'xlink:href': "images/and.png"},
            '.inPorts .port-body': { fill: 'PaleGreen' },
            '.outPorts .port-body': { fill: 'Tomato' }
        }

    }, joint.shapes.arbol.Model.prototype.defaults),
    getPortAttrs: function(portName, index, total, selector, type) {

        var attrs = {};

        var portClass = 'port' + index;
        var portSelector = selector + '>.' + portClass;
        var portLabelSelector = portSelector + '>.port-label';
        var portBodySelector = portSelector + '>.port-body';

        attrs[portLabelSelector] = { text: portName };
        attrs[portBodySelector] = { port: { id: portName || _.uniqueId(type) , type: type } };
        attrs[portSelector] = { ref: '.body', 'ref-x': (index + 0.5) * (1 / total) };

        if (selector === '.inPorts') { attrs[portSelector]['ref-dy'] = 2; }
        if (selector === '.outPorts') { attrs[portSelector]['ref-y'] = -10; }       
       return attrs;
    }

});

//joint.shapes.arbol.CompuertaAND;

/*Compuerta OR*/
joint.shapes.arbol.CompuertaOR = joint.shapes.arbol.Model.extend({

    defaults: joint.util.deepSupplement({

        type: 'arbol.CompuertaOR',
        size: { width: 80, height: 80 },
        attrs: {
            '.body': { fill: 'salmon' },
            '.label': { text: '' },
             image: { 
                width:80,
                height:80,
                'xlink:href': "images/or.png"},
            '.inPorts .port-body': { fill: 'PaleGreen' },
            '.outPorts .port-body': { fill: 'Tomato' }
        }

    }, joint.shapes.arbol.Model.prototype.defaults),
    getPortAttrs: function(portName, index, total, selector, type) {

        var attrs = {};

        var portClass = 'port' + index;
        var portSelector = selector + '>.' + portClass;
        var portLabelSelector = portSelector + '>.port-label';
        var portBodySelector = portSelector + '>.port-body';

        attrs[portLabelSelector] = { text: portName };
        attrs[portBodySelector] = { port: { id: portName || _.uniqueId(type) , type: type } };
        attrs[portSelector] = { ref: '.body', 'ref-x': (index + 0.5) * (1 / total) };

        if (selector === '.inPorts') { attrs[portSelector]['ref-dy'] = 2; }
        if (selector === '.outPorts') { attrs[portSelector]['ref-y'] = -10; }       
       return attrs;
    }

});


/*Compuerta OR Exclusiva*/
joint.shapes.arbol.CompuertaOREX = joint.shapes.arbol.Model.extend({

    defaults: joint.util.deepSupplement({

        type: 'arbol.CompuertaOREX',
        size: { width: 80, height: 80 },
        attrs: {
            '.body': { fill: 'salmon' },
            '.label': { text: '' },
             image: { 
                width:80,
                height:80,
                'xlink:href': "images/orEx.png"},
            '.inPorts .port-body': { fill: 'PaleGreen' },
            '.outPorts .port-body': { fill: 'Tomato' }
        }

    }, joint.shapes.arbol.Model.prototype.defaults),
    getPortAttrs: function(portName, index, total, selector, type) {

        var attrs = {};

        var portClass = 'port' + index;
        var portSelector = selector + '>.' + portClass;
        var portLabelSelector = portSelector + '>.port-label';
        var portBodySelector = portSelector + '>.port-body';

        attrs[portLabelSelector] = { text: portName };
        attrs[portBodySelector] = { port: { id: portName || _.uniqueId(type) , type: type } };
        attrs[portSelector] = { ref: '.body', 'ref-x': (index + 0.5) * (1 / total) };

        if (selector === '.inPorts') { attrs[portSelector]['ref-dy'] = 2; }
        if (selector === '.outPorts') { attrs[portSelector]['ref-y'] = -10; }       
       return attrs;
    }


});

/*Compuerta And Prioritaria*/
joint.shapes.arbol.CompuertaANDPRI = joint.shapes.arbol.Model.extend({

    defaults: joint.util.deepSupplement({

        type: 'arbol.CompuertaANDPRI',
        size: { width: 80, height: 80 },
        attrs: {
            '.body': { fill: 'salmon' },
            '.label': { text: '' },
             image: { 
                width:80,
                height:80,
                'xlink:href': "images/andPri.png"},
            '.inPorts .port-body': { fill: 'PaleGreen' },
            '.outPorts .port-body': { fill: 'Tomato' }
        }

    }, joint.shapes.arbol.Model.prototype.defaults),
    getPortAttrs: function(portName, index, total, selector, type) {

        var attrs = {};

        var portClass = 'port' + index;
        var portSelector = selector + '>.' + portClass;
        var portLabelSelector = portSelector + '>.port-label';
        var portBodySelector = portSelector + '>.port-body';

        attrs[portLabelSelector] = { text: portName };
        attrs[portBodySelector] = { port: { id: portName || _.uniqueId(type) , type: type } };
        attrs[portSelector] = { ref: '.body', 'ref-x': (index + 0.5) * (1 / total) };

        if (selector === '.inPorts') { attrs[portSelector]['ref-dy'] = 2; }
        if (selector === '.outPorts') { attrs[portSelector]['ref-y'] = -10; }       
       return attrs;
    }


});
/*Fin Compuerta And Prioritaria*/

/*
joint.shapes.arbol.Evento = joint.shapes.basic.Rect.extend({
    defaults: joint.util.deepSupplement({
        type: 'arbol.Evento',
        attrs: {
            rect: { stroke: 'none', 'fill-opacity': 0 },
            '.inPorts .port-body': { fill: 'PaleGreen' },
            '.outPorts .port-body': { fill: 'Tomato' }
        }
    }, joint.shapes.basic.Rect.prototype.defaults)
});*/

    /*template: [
        '<div class="evento">',
        '<button class="delete">x</button>',
        '<label></label>',
        '<span></span>', '<br/>',
        '<select><option>--</option><option>one</option><option>two</option></select>',
        '<input type="text" value="I\'m HTML input" />',
        '</div>'
    ].join(''),
            */
    //Editado Ramon       
    joint.shapes.arbol.EventoIniciador=joint.shapes.arbol.Model.extend({
    defaults: joint.util.deepSupplement({

        type: 'arbol.EventoIniciador',
        size: { width: 100, height: 50 },
        attrs: {           
            '.label': { text: '' },            
            '.inPorts .port-body': { fill: 'PaleGreen' },
            '.outPorts .port-body': { fill: 'Tomato' }
        }

    }, joint.shapes.arbol.Model.prototype.defaults),
    getPortAttrs: function(portName, index, total, selector, type) {

        var attrs = {};

        var portClass = 'port' + index;
        var portSelector = selector + '>.' + portClass;
        var portLabelSelector = portSelector + '>.port-label';
        var portBodySelector = portSelector + '>.port-body';

        attrs[portLabelSelector] = { text: portName };
        attrs[portBodySelector] = { port: { id: portName || _.uniqueId(type) , type: type } };
        attrs[portSelector] = { ref: '.body', 'ref-y': (index + 0.2) * (1 / total) };

        if (selector === '.inPorts') { attrs[portSelector]['ref-x'] = 100; }
        if (selector === '.outPorts') { attrs[portSelector]['ref-dx'] = 200; }       
       return attrs;
    }
    });
    
    joint.shapes.arbol.Sistema=joint.shapes.arbol.Model.extend({
    defaults: joint.util.deepSupplement({

        type: 'arbol.Sistema',
        size: { width: 100, height: 50 },
        attrs: {           
            '.label': { text: '' },            
            '.inPorts .port-body': { fill: 'PaleGreen' },
            '.outPorts .port-body': { fill: 'Tomato' }
        }

    }, joint.shapes.arbol.Model.prototype.defaults),
    getPortAttrs: function(portName, index, total, selector, type) {

        var attrs = {};

        var portClass = 'port' + index;
        var portSelector = selector + '>.' + portClass;
        var portLabelSelector = portSelector + '>.port-label';
        var portBodySelector = portSelector + '>.port-body';

        attrs[portLabelSelector] = { text: portName };
        attrs[portBodySelector] = { port: { id: portName || _.uniqueId(type) , type: type } };
        attrs[portSelector] = { ref: '.body', 'ref-y': (index + 0.9) * (1 / total) };

        if (selector === '.inPorts') { attrs[portSelector]['ref-x'] = -20; }
        if (selector === '.outPorts') { attrs[portSelector]['ref-dx'] = 100; }       
       return attrs;
    }
    });
    
    joint.shapes.arbol.Frecuencia=joint.shapes.arbol.Model.extend({
    defaults: joint.util.deepSupplement({

        type: 'arbol.Frecuencia',
        size: { width: 100, height: 50 },
        attrs: {           
            '.label': { text: '' },            
            '.inPorts .port-body': { fill: 'PaleGreen' },
            '.outPorts .port-body': { fill: 'Tomato' }
        }

    }, joint.shapes.arbol.Model.prototype.defaults),
    getPortAttrs: function(portName, index, total, selector, type) {

        var attrs = {};

        var portClass = 'port' + index;
        var portSelector = selector + '>.' + portClass;
        var portLabelSelector = portSelector + '>.port-label';
        var portBodySelector = portSelector + '>.port-body';

        attrs[portLabelSelector] = { text: portName };
        attrs[portBodySelector] = { port: { id: portName || _.uniqueId(type) , type: type } };
        attrs[portSelector] = { ref: '.body', 'ref-y': (index + 0.2) * (1 / total) };

        if (selector === '.inPorts') { attrs[portSelector]['ref-x'] = -25; }
        if (selector === '.outPorts') { attrs[portSelector]['ref-dx'] = 2   ; }       
       return attrs;
    }
    });
    
    joint.shapes.arbol.Exito=joint.shapes.arbol.Model.extend({
    defaults: joint.util.deepSupplement({

        type: 'arbol.Exito',
        size: { width: 100, height: 50 },
        attrs: {           
            '.label': { text: '' },            
            '.inPorts .port-body': { fill: 'PaleGreen' },
            '.outPorts .port-body': { fill: 'Tomato' }
        }

    }, joint.shapes.arbol.Model.prototype.defaults),
    getPortAttrs: function(portName, index, total, selector, type) {

        var attrs = {};

        var portClass = 'port' + index;
        var portSelector = selector + '>.' + portClass;
        var portLabelSelector = portSelector + '>.port-label';
        var portBodySelector = portSelector + '>.port-body';

        attrs[portLabelSelector] = { text: portName };
        attrs[portBodySelector] = { port: { id: portName || _.uniqueId(type) , type: type } };
        attrs[portSelector] = { ref: '.body', 'ref-y': (index + -20) * (1 / total) };

        if (selector === '.inPorts') { attrs[portSelector]['ref-x'] = -20; }
        if (selector === '.outPorts') { attrs[portSelector]['ref-dx'] = 2; }       
       return attrs;
    }
    });
    
    joint.shapes.arbol.EventoIniciadorModelView = joint.dia.ElementView.extend({

    template: [
        '<div class="eventoIniciador">',
        '<button class="delete">x</button>',
        '<input class="name" name="valorFrecuencia" type="text" size="9"  value="1" />',
        '</div>'
    ].join(''),

    initialize: function() {
        _.bindAll(this, 'updateBox');
        joint.dia.ElementView.prototype.initialize.apply(this, arguments);

        this.$box = $(_.template(this.template)());
        caja=this;
         console.log(this);
         this.$box.on('mouseover',function(evt) { 
           
            console.log($(evt.target));
            console.log($(evt.target).context.nodeName=='DIV');{
          
            console.log($(evt.target).find('button').css('display'));

            //if($(evt.target).find('button').css('display')=="none")
            $(evt.target).find('button').css('display', 'block');
           // $(evt.target).find('.delete').on('click', _.bind($(evt.target).model.remove,$(evt.target).model));
           // else
               // $(evt.target).find('button').css('display', 'none');

            //$(evt.target).css('pointer-events', 'none');
            console.log('P');
            evt.stopPropagation(); 
        }

        });
       
        // Prevent paper from handling pointerdown.
        this.$box.find('input').on('mousedown click', function(evt) { evt.stopPropagation(); });
        //this.$box.find('input select').on('mousedown click', function(evt) { evt.stopPropagation(); });
        // This is an example of reacting on the input change and storing the input data in the cell model.
        this.$box.find('input').on('change', _.bind(function(evt) {
            //this.model.set('input', $(evt.target).val());
        }, this));
         this.$box.find('.name').on('change', _.bind(function(evt) {
            //alert($);
            console.log("en name",$(evt.target).val());
        }, this));
        
        this.$box.find('.value').on('change', _.bind(function(evt) {
            //alert($);
            console.log("en value",$(evt.target).val());
        }, this));
        
        /*this.$box.find('select').on('change', _.bind(function(evt) {
            this.model.set('select', $(evt.target).val());            
        }, this));*/
        this.$box.find('.eventoIniciador').on('mousehover',_.bind(function(evt){
            console.log("capturando evento hover de Evento");
        },this));
        
        //this.$box.find('select').val(this.model.get('select'));
        //console.log("this");
        //console.log(this);
        this.$box.find('.delete').on('click', function(evt)
            {
                    console.log(caja);
                    var r = confirm("Eliminar elemento?");

                    if (r == true) {
                        caja.model.remove();
                        caja.$box.remove();
                    } else {
                        //this.$box.css('pointer-events', 'auto');
                      caja.$box.find('button').css('display', 'none');
                      //this.updateBox();
                     //   this.$box.css('pointer-events', 'none');
                    }
                   
            });
        // Update the box position whenever the underlying model changes.
        this.model.on('change', this.updateBox, this);
        // Remove the box when the model gets removed from the graph.
        //this.model.on('remove', this.removeBox, this);              
        this.updateBox();
        this.listenTo(this.model, 'process:ports', this.update);
        joint.dia.ElementView.prototype.initialize.apply(this, arguments);

    }, renderPorts: function () {
        var $inPorts = this.$('.inPorts').empty();
        var $outPorts = this.$('.outPorts').empty();

        var portTemplate = _.template(this.model.portMarkup);

        _.each(_.filter(this.model.ports, function (p) { return p.type === 'in' }), function (port, index) {

            $inPorts.append(V(portTemplate({ id: index, port: port })).node);
        });
        _.each(_.filter(this.model.ports, function (p) { return p.type === 'out' }), function (port, index) {

            $outPorts.append(V(portTemplate({ id: index, port: port })).node);
        });
    }, 

    update: function () {

        // First render ports so that `attrs` can be applied to those newly created DOM elements
        // in `ElementView.prototype.update()`.
        this.renderPorts();
        joint.dia.ElementView.prototype.update.apply(this, arguments);
    },
    render: function() {
        joint.dia.ElementView.prototype.render.apply(this, arguments);
        this.paper.$el.prepend(this.$box);
        this.updateBox();
        return this;
    },
    updateBox: function() {
        // Set the position and dimension of the box so that it covers the JointJS element.
        var bbox = this.model.getBBox();
        // Example of updating the HTML with a data stored in the cell model.
       // this.$box.find('hover',this.$box.css('visibility','hidden'));
        this.$box.find('label').text(this.model.get('label'));
        //this.$box.find('span').text(this.model.get('select'));
        this.$box.css({ width: bbox.width, height: bbox.height, left: bbox.x, top: bbox.y, transform: 'rotate(' + (this.model.get('angle') || 0) + 'deg)' });
         this.$box.find('button').css('display', 'none');
            this.$box.css('pointer-events', 'auto');
        //this.$box.css('pointer-events', 'auto');
     console.log(this.$box.find('button'));
    },
    removeBox: function(evt) {
        //var context=this.$box.context;
        var r = confirm("Eliminar elemento dos ?");

            if (r == true) {
               // this.modelremove();
                //this.$box.remove();
                
                
            } else {
                //this.$box.css('pointer-events', 'auto');
              //this.$box.find('button .delete').css('display', 'none');
              //this.updateBox();
             //   this.$box.css('pointer-events', 'none');
            }
       
    }
});
    
    joint.shapes.arbol.SistemaModelView = joint.dia.ElementView.extend({

    template: [
        '<div class="sistema">',
        '<input class="name" name="valorFrecuencia" type="text" size="9"  value="1" />',
        '</div>'
    ].join(''),

    initialize: function() {
        _.bindAll(this, 'updateBox');
        joint.dia.ElementView.prototype.initialize.apply(this, arguments);

        this.$box = $(_.template(this.template)());
        caja=this;
         console.log(this);
         this.$box.on('mouseover',function(evt) { 
           
            console.log($(evt.target));
            console.log($(evt.target).context.nodeName=='DIV');{
          
            console.log($(evt.target).find('button').css('display'));

            //if($(evt.target).find('button').css('display')=="none")
            $(evt.target).find('button').css('display', 'block');
           // $(evt.target).find('.delete').on('click', _.bind($(evt.target).model.remove,$(evt.target).model));
           // else
               // $(evt.target).find('button').css('display', 'none');

            //$(evt.target).css('pointer-events', 'none');
            console.log('P');
            evt.stopPropagation(); 
        }

        });
       
        // Prevent paper from handling pointerdown.
        this.$box.find('input').on('mousedown click', function(evt) { evt.stopPropagation(); });
        //this.$box.find('input select').on('mousedown click', function(evt) { evt.stopPropagation(); });
        // This is an example of reacting on the input change and storing the input data in the cell model.
        this.$box.find('input').on('change', _.bind(function(evt) {
            //this.model.set('input', $(evt.target).val());
        }, this));
         this.$box.find('.name').on('change', _.bind(function(evt) {
            //alert($);
            console.log("en name",$(evt.target).val());
        }, this));
        
        this.$box.find('.value').on('change', _.bind(function(evt) {
            //alert($);
            console.log("en value",$(evt.target).val());
        }, this));
        
        /*this.$box.find('select').on('change', _.bind(function(evt) {
            this.model.set('select', $(evt.target).val());            
        }, this));*/
        this.$box.find('.sistema').on('mousehover',_.bind(function(evt){
            console.log("capturando evento hover de Evento");
        },this));
        
        //this.$box.find('select').val(this.model.get('select'));
        //console.log("this");
        //console.log(this);
        this.$box.find('.delete').on('click', function(evt)
            {
                    console.log(caja);
                    var r = confirm("Eliminar elemento?");

                    if (r == true) {
                        caja.model.remove();
                        caja.$box.remove();
                    } else {
                        //this.$box.css('pointer-events', 'auto');
                      caja.$box.find('button').css('display', 'none');
                      //this.updateBox();
                     //   this.$box.css('pointer-events', 'none');
                    }
                   
            });
        // Update the box position whenever the underlying model changes.
        this.model.on('change', this.updateBox, this);
        // Remove the box when the model gets removed from the graph.
        //this.model.on('remove', this.removeBox, this);              
        this.updateBox();
        this.listenTo(this.model, 'process:ports', this.update);
        joint.dia.ElementView.prototype.initialize.apply(this, arguments);

    }, renderPorts: function () {
        var $inPorts = this.$('.inPorts').empty();
        var $outPorts = this.$('.outPorts').empty();

        var portTemplate = _.template(this.model.portMarkup);

        _.each(_.filter(this.model.ports, function (p) { return p.type === 'in' }), function (port, index) {

            $inPorts.append(V(portTemplate({ id: index, port: port })).node);
        });
        _.each(_.filter(this.model.ports, function (p) { return p.type === 'out' }), function (port, index) {

            $outPorts.append(V(portTemplate({ id: index, port: port })).node);
        });
    }, 

    update: function () {

        // First render ports so that `attrs` can be applied to those newly created DOM elements
        // in `ElementView.prototype.update()`.
        this.renderPorts();
        joint.dia.ElementView.prototype.update.apply(this, arguments);
    },
    render: function() {
        joint.dia.ElementView.prototype.render.apply(this, arguments);
        this.paper.$el.prepend(this.$box);
        this.updateBox();
        return this;
    },
    updateBox: function() {
        // Set the position and dimension of the box so that it covers the JointJS element.
        var bbox = this.model.getBBox();
        // Example of updating the HTML with a data stored in the cell model.
       // this.$box.find('hover',this.$box.css('visibility','hidden'));
        this.$box.find('label').text(this.model.get('label'));
        //this.$box.find('span').text(this.model.get('select'));
        this.$box.css({ width: bbox.width, height: bbox.height, left: bbox.x, top: bbox.y, transform: 'rotate(' + (this.model.get('angle') || 0) + 'deg)' });
         this.$box.find('button').css('display', 'none');
            this.$box.css('pointer-events', 'auto');
        //this.$box.css('pointer-events', 'auto');
     console.log(this.$box.find('button'));
    },
    removeBox: function(evt) {
        //var context=this.$box.context;
        var r = confirm("Eliminar elemento dos ?");

            if (r == true) {
               // this.modelremove();
                //this.$box.remove();
                
                
            } else {
                //this.$box.css('pointer-events', 'auto');
              //this.$box.find('button .delete').css('display', 'none');
              //this.updateBox();
             //   this.$box.css('pointer-events', 'none');
            }
       
    }
});

joint.shapes.arbol.FrecuenciaModelView = joint.dia.ElementView.extend({

    template: [
        '<div class="frecuencia">',
        '<button class="delete">x</button>',
        '<input class="name" name="valorFrecuencia" type="text" size="9"  value="1" />',
        '</div>'
    ].join(''),

    initialize: function() {
        _.bindAll(this, 'updateBox');
        joint.dia.ElementView.prototype.initialize.apply(this, arguments);

        this.$box = $(_.template(this.template)());
        caja=this;
         console.log(this);
         this.$box.on('mouseover',function(evt) { 
           
            console.log($(evt.target));
            console.log($(evt.target).context.nodeName=='DIV');{
          
            console.log($(evt.target).find('button').css('display'));

            //if($(evt.target).find('button').css('display')=="none")
            $(evt.target).find('button').css('display', 'block');
           // $(evt.target).find('.delete').on('click', _.bind($(evt.target).model.remove,$(evt.target).model));
           // else
               // $(evt.target).find('button').css('display', 'none');

            //$(evt.target).css('pointer-events', 'none');
            console.log('P');
            evt.stopPropagation(); 
        }

        });
       
        // Prevent paper from handling pointerdown.
        this.$box.find('input').on('mousedown click', function(evt) { evt.stopPropagation(); });
        //this.$box.find('input select').on('mousedown click', function(evt) { evt.stopPropagation(); });
        // This is an example of reacting on the input change and storing the input data in the cell model.
        this.$box.find('input').on('change', _.bind(function(evt) {
            //this.model.set('input', $(evt.target).val());
        }, this));
         this.$box.find('.name').on('change', _.bind(function(evt) {
            //alert($);
            console.log("en name",$(evt.target).val());
        }, this));
        
        this.$box.find('.value').on('change', _.bind(function(evt) {
            //alert($);
            console.log("en value",$(evt.target).val());
        }, this));
        
        /*this.$box.find('select').on('change', _.bind(function(evt) {
            this.model.set('select', $(evt.target).val());            
        }, this));*/
        this.$box.find('.frecuencia').on('mousehover',_.bind(function(evt){
            console.log("capturando evento hover de Evento");
        },this));
        
        //this.$box.find('select').val(this.model.get('select'));
        //console.log("this");
        //console.log(this);
        this.$box.find('.delete').on('click', function(evt)
            {
                    console.log(caja);
                    var r = confirm("Eliminar elemento?");

                    if (r == true) {
                        caja.model.remove();
                        caja.$box.remove();
                    } else {
                        //this.$box.css('pointer-events', 'auto');
                      caja.$box.find('button').css('display', 'none');
                      //this.updateBox();
                     //   this.$box.css('pointer-events', 'none');
                    }
                   
            });
        // Update the box position whenever the underlying model changes.
        this.model.on('change', this.updateBox, this);
        // Remove the box when the model gets removed from the graph.
        //this.model.on('remove', this.removeBox, this);              
        this.updateBox();
        this.listenTo(this.model, 'process:ports', this.update);
        joint.dia.ElementView.prototype.initialize.apply(this, arguments);

    }, renderPorts: function () {
        var $inPorts = this.$('.inPorts').empty();
        var $outPorts = this.$('.outPorts').empty();

        var portTemplate = _.template(this.model.portMarkup);

        _.each(_.filter(this.model.ports, function (p) { return p.type === 'in' }), function (port, index) {

            $inPorts.append(V(portTemplate({ id: index, port: port })).node);
        });
        _.each(_.filter(this.model.ports, function (p) { return p.type === 'out' }), function (port, index) {

            $outPorts.append(V(portTemplate({ id: index, port: port })).node);
        });
    }, 

    update: function () {

        // First render ports so that `attrs` can be applied to those newly created DOM elements
        // in `ElementView.prototype.update()`.
        this.renderPorts();
        joint.dia.ElementView.prototype.update.apply(this, arguments);
    },
    render: function() {
        joint.dia.ElementView.prototype.render.apply(this, arguments);
        this.paper.$el.prepend(this.$box);
        this.updateBox();
        return this;
    },
    updateBox: function() {
        // Set the position and dimension of the box so that it covers the JointJS element.
        var bbox = this.model.getBBox();
        // Example of updating the HTML with a data stored in the cell model.
       // this.$box.find('hover',this.$box.css('visibility','hidden'));
        this.$box.find('label').text(this.model.get('label'));
        //this.$box.find('span').text(this.model.get('select'));
        this.$box.css({ width: bbox.width, height: bbox.height, left: bbox.x, top: bbox.y, transform: 'rotate(' + (this.model.get('angle') || 0) + 'deg)' });
         this.$box.find('button').css('display', 'none');
            this.$box.css('pointer-events', 'auto');
        //this.$box.css('pointer-events', 'auto');
     console.log(this.$box.find('button'));
    },
    removeBox: function(evt) {
        //var context=this.$box.context;
        var r = confirm("Eliminar elemento dos ?");

            if (r == true) {
               // this.modelremove();
                //this.$box.remove();
                
                
            } else {
                //this.$box.css('pointer-events', 'auto');
              //this.$box.find('button .delete').css('display', 'none');
              //this.updateBox();
             //   this.$box.css('pointer-events', 'none');
            }
       
    }
});

joint.shapes.arbol.ExitoModelView = joint.dia.ElementView.extend({

    template: [
        '<div class="exito">',
        '<input class="name" name="valor" type="text" size="9"  value="1" />',
        '</div>'
    ].join(''),

    initialize: function() {
        _.bindAll(this, 'updateBox');
        joint.dia.ElementView.prototype.initialize.apply(this, arguments);

        this.$box = $(_.template(this.template)());
        caja=this;
         console.log(this);
         this.$box.on('mouseover',function(evt) { 
           
            console.log($(evt.target));
            console.log($(evt.target).context.nodeName=='DIV');{
          
            console.log($(evt.target).find('button').css('display'));

            //if($(evt.target).find('button').css('display')=="none")
            $(evt.target).find('button').css('display', 'block');
           // $(evt.target).find('.delete').on('click', _.bind($(evt.target).model.remove,$(evt.target).model));
           // else
               // $(evt.target).find('button').css('display', 'none');

            //$(evt.target).css('pointer-events', 'none');
            console.log('P');
            evt.stopPropagation(); 
        }

        });
       
        // Prevent paper from handling pointerdown.
        this.$box.find('input').on('mousedown click', function(evt) { evt.stopPropagation(); });
        //this.$box.find('input select').on('mousedown click', function(evt) { evt.stopPropagation(); });
        // This is an example of reacting on the input change and storing the input data in the cell model.
        this.$box.find('input').on('change', _.bind(function(evt) {
            //this.model.set('input', $(evt.target).val());
        }, this));
         this.$box.find('.name').on('change', _.bind(function(evt) {
            //alert($);
            console.log("en name",$(evt.target).val());
        }, this));
        
        this.$box.find('.value').on('change', _.bind(function(evt) {
            //alert($);
            console.log("en value",$(evt.target).val());
        }, this));
        
        /*this.$box.find('select').on('change', _.bind(function(evt) {
            this.model.set('select', $(evt.target).val());            
        }, this));*/
        this.$box.find('.exito').on('mousehover',_.bind(function(evt){
            console.log("capturando evento hover de Evento");
        },this));
        
        //this.$box.find('select').val(this.model.get('select'));
        //console.log("this");
        //console.log(this);
        this.$box.find('.delete').on('click', function(evt)
            {
                    console.log(caja);
                    var r = confirm("Eliminar elemento?");

                    if (r == true) {
                        caja.model.remove();
                        caja.$box.remove();
                    } else {
                        //this.$box.css('pointer-events', 'auto');
                      caja.$box.find('button').css('display', 'none');
                      //this.updateBox();
                     //   this.$box.css('pointer-events', 'none');
                    }
                   
            });
        // Update the box position whenever the underlying model changes.
        this.model.on('change', this.updateBox, this);
        // Remove the box when the model gets removed from the graph.
        //this.model.on('remove', this.removeBox, this);              
        this.updateBox();
        this.listenTo(this.model, 'process:ports', this.update);
        joint.dia.ElementView.prototype.initialize.apply(this, arguments);

    }, renderPorts: function () {
        var $inPorts = this.$('.inPorts').empty();
        var $outPorts = this.$('.outPorts').empty();

        var portTemplate = _.template(this.model.portMarkup);

        _.each(_.filter(this.model.ports, function (p) { return p.type === 'in' }), function (port, index) {

            $inPorts.append(V(portTemplate({ id: index, port: port })).node);
        });
        _.each(_.filter(this.model.ports, function (p) { return p.type === 'out' }), function (port, index) {

            $outPorts.append(V(portTemplate({ id: index, port: port })).node);
        });
    }, 

    update: function () {

        // First render ports so that `attrs` can be applied to those newly created DOM elements
        // in `ElementView.prototype.update()`.
        this.renderPorts();
        joint.dia.ElementView.prototype.update.apply(this, arguments);
    },
    render: function() {
        joint.dia.ElementView.prototype.render.apply(this, arguments);
        this.paper.$el.prepend(this.$box);
        this.updateBox();
        return this;
    },
    updateBox: function() {
        // Set the position and dimension of the box so that it covers the JointJS element.
        var bbox = this.model.getBBox();
        // Example of updating the HTML with a data stored in the cell model.
       // this.$box.find('hover',this.$box.css('visibility','hidden'));
        this.$box.find('label').text(this.model.get('label'));
        //this.$box.find('span').text(this.model.get('select'));
        this.$box.css({ width: bbox.width, height: bbox.height, left: bbox.x, top: bbox.y, transform: 'rotate(' + (this.model.get('angle') || 0) + 'deg)' });
         this.$box.find('button').css('display', 'none');
            this.$box.css('pointer-events', 'auto');
        //this.$box.css('pointer-events', 'auto');
     console.log(this.$box.find('button'));
    },
    removeBox: function(evt) {
        //var context=this.$box.context;
        var r = confirm("Eliminar elemento dos ?");

            if (r == true) {
               // this.modelremove();
                //this.$box.remove();
                
                
            } else {
                //this.$box.css('pointer-events', 'auto');
              //this.$box.find('button .delete').css('display', 'none');
              //this.updateBox();
             //   this.$box.css('pointer-events', 'none');
            }
       
    }
});
    
    //Termina editado Ramon
    
     // function capturaInputEvento(evento){
     //    var eventoValue=evento;
     //        alert(evento);
     //    }
     var valorEvento="";
     var valorCompuerta="";

joint.shapes.arbol.ModelView = joint.dia.ElementView.extend({

    template: [
        '<div class="evento">',
        '<button class="delete">x</button>',
        '<input class="name" name="nameEvento" type="text"  value="1" />',
        '<input class="value" name="valueEvento" type="text" size="5" value="0" />',
        '</div>'
    ].join(''),

    initialize: function() {
        _.bindAll(this, 'updateBox');
        joint.dia.ElementView.prototype.initialize.apply(this, arguments);

        this.$box = $(_.template(this.template)());
        caja=this;
         console.log(this);
         this.$box.on('mouseover',function(evt) { 
           
            console.log($(evt.target));
            console.log($(evt.target).context.nodeName=='DIV');{
          
            console.log($(evt.target).find('button').css('display'));

            //if($(evt.target).find('button').css('display')=="none")
            $(evt.target).find('button').css('display', 'block');
           // $(evt.target).find('.delete').on('click', _.bind($(evt.target).model.remove,$(evt.target).model));
           // else
               // $(evt.target).find('button').css('display', 'none');

            //$(evt.target).css('pointer-events', 'none');
            console.log('P');
            evt.stopPropagation(); 
        }

        });
       
        // Prevent paper from handling pointerdown.
       
        this.$box.find('input').on('mousedown click', function(evt) { evt.stopPropagation(); });
        //this.$box.find('input select').on('mousedown click', function(evt) { evt.stopPropagation(); });
        // This is an example of reacting on the input change and storing the input data in the cell model.
        this.$box.find('input').on('change', _.bind(function(evt) {
            //this.model.set('input', $(evt.target).val());
        }, this));
         this.$box.find('.name').on('change', _.bind(function(evt) {
            //alert($);
            console.log("en name",$(evt.target).val());
        }, this));
        
        this.$box.find('.value').on('change', _.bind(function(evt) {
            //alert($);
            console.log("en value",$(evt.target).val());
            valorEvento=$(evt.target).val();
        }, this));
        
        /*this.$box.find('select').on('change', _.bind(function(evt) {
            this.model.set('select', $(evt.target).val());            
        }, this));*/
        this.$box.find('.evento').on('mousehover',_.bind(function(evt){
            console.log("capturando evento hover de Evento");
        },this));
        
        //this.$box.find('select').val(this.model.get('select'));
        //console.log("this");
        //console.log(this);
        this.$box.find('.delete').on('click', function(evt)
            {
                    console.log(caja);
                    var r = confirm("Eliminar elemento?");

                    if (r == true) {
                        caja.model.remove();
                        caja.$box.remove();
                    } else {
                        //this.$box.css('pointer-events', 'auto');
                      caja.$box.find('button').css('display', 'none');
                      //this.updateBox();
                     //   this.$box.css('pointer-events', 'none');
                    }
                   
            });
        // Update the box position whenever the underlying model changes.
        this.model.on('change', this.updateBox, this);
        // Remove the box when the model gets removed from the graph.
        //this.model.on('remove', this.removeBox, this);              
        this.updateBox();
        this.listenTo(this.model, 'process:ports', this.update);
        joint.dia.ElementView.prototype.initialize.apply(this, arguments);

    }, renderPorts: function () {
        var $inPorts = this.$('.inPorts').empty();
        var $outPorts = this.$('.outPorts').empty();

        var portTemplate = _.template(this.model.portMarkup);

        _.each(_.filter(this.model.ports, function (p) { return p.type === 'in' }), function (port, index) {

            $inPorts.append(V(portTemplate({ id: index, port: port })).node);
        });
        _.each(_.filter(this.model.ports, function (p) { return p.type === 'out' }), function (port, index) {

            $outPorts.append(V(portTemplate({ id: index, port: port })).node);
        });
    }, 

    update: function () {

        // First render ports so that `attrs` can be applied to those newly created DOM elements
        // in `ElementView.prototype.update()`.
        this.renderPorts();
        joint.dia.ElementView.prototype.update.apply(this, arguments);
    },
    render: function() {
        joint.dia.ElementView.prototype.render.apply(this, arguments);
        this.paper.$el.prepend(this.$box);
        this.updateBox();
        return this;
    },
    updateBox: function() {
        // Set the position and dimension of the box so that it covers the JointJS element.
        var bbox = this.model.getBBox();
        // Example of updating the HTML with a data stored in the cell model.
       // this.$box.find('hover',this.$box.css('visibility','hidden'));
        this.$box.find('label').text(this.model.get('label'));
        //this.$box.find('span').text(this.model.get('select'));
        this.$box.css({ width: bbox.width, height: bbox.height, left: bbox.x, top: bbox.y, transform: 'rotate(' + (this.model.get('angle') || 0) + 'deg)' });
         this.$box.find('button').css('display', 'none');
            this.$box.css('pointer-events', 'auto');
        //this.$box.css('pointer-events', 'auto');
     console.log(this.$box.find('button'));
    },
    removeBox: function(evt) {
        //var context=this.$box.context;
        var r = confirm("Eliminar elemento dos ?");

            if (r == true) {
               // this.modelremove();
                //this.$box.remove();
                
                
            } else {
                //this.$box.css('pointer-events', 'auto');
              //this.$box.find('button .delete').css('display', 'none');
              //this.updateBox();
             //   this.$box.css('pointer-events', 'none');
            }
       
    }
});

//definiendo vista compuerta
joint.shapes.arbol.CompuertaView = joint.dia.ElementView.extend({

    template: [
        '<div class="compuerta">',
        '<button class="delete">x</button>',       
        '</div>'
    ].join(''),

    initialize: function() {
        _.bindAll(this, 'updateBox');
        joint.dia.ElementView.prototype.initialize.apply(this, arguments);

        this.$box = $(_.template(this.template)());
        this.caja=this;
        console.log('inicializando caja');
         console.log(this);

         this.$box.on('mouseover',_.bind(function(evt) { 
           
            console.log(this.model.attributes.type.replace("arbol.", ""));
            //aqui
            
            valorCompuerta=this.model.attributes.type.replace("arbol.", "");
            // calculaOperaciones();
            console.log($(evt.target).context.nodeName=='DIV');{
          
            console.log($(evt.target).find('button').css('display'));

            //if($(evt.target).find('button').css('display')=="none")
            $(evt.target).find('button').css('display', 'block');
           // $(evt.target).find('.delete').on('click', _.bind($(evt.target).model.remove,$(evt.target).model));
           // else
               // $(evt.target).find('button').css('display', 'none');

            //$(evt.target).css('pointer-events', 'none');
            console.log('P');
            evt.stopPropagation(); 
        }

        },this));
       
        
        /*this.$box.find('select').on('change', _.bind(function(evt) {
            this.model.set('select', $(evt.target).val());            
        }, this));*/
        this.$box.find('.evento').on('mousehover',_.bind(function(evt){
            console.log("capturando evento hover de Evento");
        },this));
        
        //this.$box.find('select').val(this.model.get('select'));
        console.log("this");
        console.log(this);
        this.$box.find('button').on('click',_.bind( function(evt)
            {

                    console.log(caja);
                    var r = confirm("Eliminar elemento?");

                    if (r == true) {
                        this.model.remove();
                        this.$box.remove();
                    } else {
                        //this.$box.css('pointer-events', 'auto');
                      this.$box.find('button').css('display', 'none');
                      //this.updateBox();
                     //   this.$box.css('pointer-events', 'none');
                    }
                   
            },this));
        // Update the box position whenever the underlying model changes.
        this.model.on('change', this.updateBox, this);
        // Remove the box when the model gets removed from the graph.
        //this.model.on('remove', this.removeBox, this);              
        this.updateBox();
        this.listenTo(this.model, 'process:ports', this.update);
        joint.dia.ElementView.prototype.initialize.apply(this, arguments);

    }, renderPorts: function () {
        var $inPorts = this.$('.inPorts').empty();
        var $outPorts = this.$('.outPorts').empty();

        var portTemplate = _.template(this.model.portMarkup);

        _.each(_.filter(this.model.ports, function (p) { return p.type === 'in' }), function (port, index) {

            $inPorts.append(V(portTemplate({ id: index, port: port })).node);
        });
        _.each(_.filter(this.model.ports, function (p) { return p.type === 'out' }), function (port, index) {

            $outPorts.append(V(portTemplate({ id: index, port: port })).node);
        });
    }, 

    update: function () {

        // First render ports so that `attrs` can be applied to those newly created DOM elements
        // in `ElementView.prototype.update()`.
        this.renderPorts();
        joint.dia.ElementView.prototype.update.apply(this, arguments);
    },
    render: function() {
        joint.dia.ElementView.prototype.render.apply(this, arguments);
        this.paper.$el.prepend(this.$box);
        this.updateBox();
        return this;
    },
    updateBox: function() {
        // Set the position and dimension of the box so that it covers the JointJS element.
        var bbox = this.model.getBBox();
        // Example of updating the HTML with a data stored in the cell model.
       // this.$box.find('hover',this.$box.css('visibility','hidden'));        
        //this.$box.find('span').text(this.model.get('select'));
        this.$box.css({ width: bbox.width, height: bbox.height, left: bbox.x, top: bbox.y, transform: 'rotate(' + (this.model.get('angle') || 0) + 'deg)' });
         this.$box.find('button').css('display', 'none');
            this.$box.css('pointer-events', 'auto');
        //this.$box.css('pointer-events', 'auto');
     console.log(this.$box.find('button'));
    },
    removeBox: function(evt) {
        //var context=this.$box.context;
        var r = confirm("Eliminar elemento dos ?");

            if (r == true) {
               // this.modelremove();
                //this.$box.remove();
                
                
            } else {
                //this.$box.css('pointer-events', 'auto');
              //this.$box.find('button .delete').css('display', 'none');
              //this.updateBox();
             //   this.$box.css('pointer-events', 'none');
            }
       
    }
});



//inicio de savearbol script


//


joint.shapes.arbol.Link = joint.dia.Link.extend({

    defaults: {
    type: 'arbol.Link',
    attrs: {
            '.label': { text: 'Model', 'ref-x': .4, 'ref-y': .2 },
            rect: { fill: '#2ECC71' },
            '.inPorts circle': { fill: '#16A085', magnet: 'passive', type: 'input' },
            '.outPorts circle': { fill: '#E74C3C', type: 'output' }
        }
    }
});

//joint.shapes.arbol.ModelView = joint.dia.ElementView.extend(joint.shapes.basic.PortsViewInterface);
//joint.shapes.arbol.AtomicView = joint.shapes.arbol.ModelView;
//joint.shapes.arbol.CoupledView = joint.shapes.arbol.ModelView;
joint.shapes.arbol.CompuertaANDView = joint.shapes.arbol.CompuertaView ;
joint.shapes.arbol.CompuertaORView = joint.shapes.arbol.CompuertaView ;
joint.shapes.arbol.CompuertaOREXView = joint.shapes.arbol.CompuertaView ;
joint.shapes.arbol.CompuertaANDPRIView = joint.shapes.arbol.CompuertaView ;
joint.shapes.arbol.EventoIniciadorView = joint.dia.ElementView.extend(joint.shapes.basic.PortsViewInterface);;
joint.shapes.arbol.EventoView=joint.shapes.arbol.ModelView;
//Editado Ramon
joint.shapes.arbol.EventoIniciadorView=joint.shapes.arbol.EventoIniciadorModelView;
joint.shapes.arbol.SistemaView=joint.shapes.arbol.SistemaModelView;
joint.shapes.arbol.FrecuenciaView=joint.shapes.arbol.FrecuenciaModelView;
joint.shapes.arbol.ExitoView=joint.shapes.arbol.ExitoModelView;


if (typeof exports === 'object') {

    module.exports = joint.shapes.arbol;
}


